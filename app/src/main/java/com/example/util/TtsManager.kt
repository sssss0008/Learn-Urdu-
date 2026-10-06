package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class TtsManager(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
    private var isInitialized = false

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _currentUtteranceId = MutableStateFlow<String?>(null)
    val currentUtteranceId: StateFlow<String?> = _currentUtteranceId.asStateFlow()

    private var speechRate: Float = 0.95f // Slightly deliberate for clear language learning

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isInitialized = true
            // Attempt Urdu Locale
            val urduLocale = Locale("ur", "PK")
            val urduResult = tts?.setLanguage(urduLocale)
            if (urduResult == TextToSpeech.LANG_MISSING_DATA || urduResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Fallback to general Urdu or Hindi (phonetically very close for shared vocabulary)
                val generalUrdu = Locale("ur")
                val generalResult = tts?.setLanguage(generalUrdu)
                if (generalResult == TextToSpeech.LANG_MISSING_DATA || generalResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                    val hindiLocale = Locale("hi", "IN")
                    tts?.setLanguage(hindiLocale)
                }
            }

            tts?.setSpeechRate(speechRate)
            tts?.setPitch(1.0f)

            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _isSpeaking.value = true
                    _currentUtteranceId.value = utteranceId
                }

                override fun onDone(utteranceId: String?) {
                    _isSpeaking.value = false
                    _currentUtteranceId.value = null
                }

                override fun onError(utteranceId: String?) {
                    _isSpeaking.value = false
                    _currentUtteranceId.value = null
                }
            })
        } else {
            Log.e("TtsManager", "TTS initialization failed with status $status")
        }
    }

    fun speak(text: String, utteranceId: String = System.currentTimeMillis().toString(), slow: Boolean = false) {
        if (!isInitialized) return
        tts?.stop()
        tts?.setSpeechRate(if (slow) 0.65f else speechRate)
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
    }

    fun stop() {
        tts?.stop()
        _isSpeaking.value = false
        _currentUtteranceId.value = null
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
}
