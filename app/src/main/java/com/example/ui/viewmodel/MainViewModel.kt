package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.*
import com.example.data.repository.UrduRepository
import com.example.util.TtsManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val ttsManager = TtsManager(application)

    // Current navigation tab (0: Home, 1: Learn, 2: Practice, 3: About)
    private val _currentTab = MutableStateFlow(0)
    val currentTab: StateFlow<Int> = _currentTab.asStateFlow()

    // Current app UI language
    private val _currentLanguage = MutableStateFlow(AppLanguage.ENGLISH)
    val currentLanguage: StateFlow<AppLanguage> = _currentLanguage.asStateFlow()

    // Selected Cultural Article for Drawer detail view
    private val _selectedArticle = MutableStateFlow<CulturalArticle?>(null)
    val selectedArticle: StateFlow<CulturalArticle?> = _selectedArticle.asStateFlow()

    // Selected Poetry Sher for full modal view
    private val _selectedSher = MutableStateFlow<PoetrySher?>(null)
    val selectedSher: StateFlow<PoetrySher?> = _selectedSher.asStateFlow()

    // Learn tab state
    private val _selectedLearnCategory = MutableStateFlow<String>("all")
    val selectedLearnCategory: StateFlow<String> = _selectedLearnCategory.asStateFlow()

    private val _learnSubTab = MutableStateFlow(0) // 0: Alphabet, 1: Vocabulary, 2: Numbers, 3: Grammar
    val learnSubTab: StateFlow<Int> = _learnSubTab.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // Practice Quiz state
    private val _quizQuestions = MutableStateFlow(UrduRepository.quizQuestions)
    val quizQuestions: StateFlow<List<QuizQuestion>> = _quizQuestions.asStateFlow()

    private val _quizCurrentIndex = MutableStateFlow(0)
    val quizCurrentIndex: StateFlow<Int> = _quizCurrentIndex.asStateFlow()

    private val _quizSelectedOption = MutableStateFlow<Int?>(null)
    val quizSelectedOption: StateFlow<Int?> = _quizSelectedOption.asStateFlow()

    private val _quizIsAnswered = MutableStateFlow(false)
    val quizIsAnswered: StateFlow<Boolean> = _quizIsAnswered.asStateFlow()

    private val _quizScore = MutableStateFlow(0)
    val quizScore: StateFlow<Int> = _quizScore.asStateFlow()

    private val _quizIsFinished = MutableStateFlow(false)
    val quizIsFinished: StateFlow<Boolean> = _quizIsFinished.asStateFlow()

    // Flashcard state
    private val _flashcardIndex = MutableStateFlow(0)
    val flashcardIndex: StateFlow<Int> = _flashcardIndex.asStateFlow()

    private val _isCardFlipped = MutableStateFlow(false)
    val isCardFlipped: StateFlow<Boolean> = _isCardFlipped.asStateFlow()

    private val _masteredCards = MutableStateFlow(0)
    val masteredCards: StateFlow<Int> = _masteredCards.asStateFlow()

    // Practice Mode (0: Quiz, 1: Flashcards, 2: Listen & Match)
    private val _practiceMode = MutableStateFlow(0)
    val practiceMode: StateFlow<Int> = _practiceMode.asStateFlow()

    // Streak / stats
    private val _streakDays = MutableStateFlow(3)
    val streakDays: StateFlow<Int> = _streakDays.asStateFlow()

    private val _wordsLearnedCount = MutableStateFlow(18)
    val wordsLearnedCount: StateFlow<Int> = _wordsLearnedCount.asStateFlow()

    fun setTab(index: Int) {
        _currentTab.value = index
    }

    fun setLanguage(language: AppLanguage) {
        _currentLanguage.value = language
    }

    fun selectArticle(article: CulturalArticle?) {
        _selectedArticle.value = article
    }

    fun selectSher(sher: PoetrySher?) {
        _selectedSher.value = sher
    }

    fun setLearnCategory(categoryId: String) {
        _selectedLearnCategory.value = categoryId
    }

    fun setLearnSubTab(tab: Int) {
        _learnSubTab.value = tab
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setPracticeMode(mode: Int) {
        _practiceMode.value = mode
    }

    fun speak(text: String, slow: Boolean = false) {
        ttsManager.speak(text, slow = slow)
    }

    fun onQuizSelectOption(index: Int) {
        if (!_quizIsAnswered.value) {
            _quizSelectedOption.value = index
        }
    }

    fun onQuizSubmitAnswer() {
        val selected = _quizSelectedOption.value ?: return
        val currentQ = _quizQuestions.value.getOrNull(_quizCurrentIndex.value) ?: return

        _quizIsAnswered.value = true
        if (selected == currentQ.correctOptionIndex) {
            _quizScore.value += 10
            _wordsLearnedCount.value += 1
        }
    }

    fun onQuizNextQuestion() {
        val nextIdx = _quizCurrentIndex.value + 1
        if (nextIdx < _quizQuestions.value.size) {
            _quizCurrentIndex.value = nextIdx
            _quizSelectedOption.value = null
            _quizIsAnswered.value = false
        } else {
            _quizIsFinished.value = true
        }
    }

    fun restartQuiz() {
        _quizCurrentIndex.value = 0
        _quizSelectedOption.value = null
        _quizIsAnswered.value = false
        _quizScore.value = 0
        _quizIsFinished.value = false
    }

    fun toggleCardFlip() {
        _isCardFlipped.value = !_isCardFlipped.value
    }

    fun nextFlashcard(mastered: Boolean) {
        if (mastered) {
            _masteredCards.value += 1
            _wordsLearnedCount.value += 1
        }
        _isCardFlipped.value = false
        val total = UrduRepository.vocabItems.size
        _flashcardIndex.value = (_flashcardIndex.value + 1) % total
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.shutdown()
    }
}
