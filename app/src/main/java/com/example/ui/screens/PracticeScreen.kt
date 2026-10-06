package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.data.repository.UrduRepository
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.GoldAccent
import com.example.ui.viewmodel.MainViewModel

@Composable
fun PracticeScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val currentLang by viewModel.currentLanguage.collectAsState()
    val practiceMode by viewModel.practiceMode.collectAsState()
    val isSpeaking by viewModel.ttsManager.isSpeaking.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        // Practice Mode Selector
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("practice_mode_row")
        ) {
            val modes = listOf(
                "Quiz" to "کوئز",
                "Flashcards" to "کارڈز",
                "Listening" to "سنیں"
            )
            modes.forEachIndexed { index, (en, ur) ->
                SegmentedButton(
                    selected = practiceMode == index,
                    onClick = { viewModel.setPracticeMode(index) },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = modes.size)
                ) {
                    Text(
                        text = if (currentLang == AppLanguage.URDU) ur else en,
                        fontSize = 13.sp,
                        fontWeight = if (practiceMode == index) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        when (practiceMode) {
            0 -> QuizPracticeView(viewModel = viewModel, isSpeaking = isSpeaking, currentLang = currentLang)
            1 -> FlashcardsPracticeView(viewModel = viewModel, isSpeaking = isSpeaking, currentLang = currentLang)
            2 -> ListeningPracticeView(viewModel = viewModel, isSpeaking = isSpeaking, currentLang = currentLang)
        }
    }
}

@Composable
fun QuizPracticeView(
    viewModel: MainViewModel,
    isSpeaking: Boolean,
    currentLang: AppLanguage
) {
    val questions by viewModel.quizQuestions.collectAsState()
    val currentIndex by viewModel.quizCurrentIndex.collectAsState()
    val selectedOption by viewModel.quizSelectedOption.collectAsState()
    val isAnswered by viewModel.quizIsAnswered.collectAsState()
    val score by viewModel.quizScore.collectAsState()
    val isFinished by viewModel.quizIsFinished.collectAsState()

    if (isFinished) {
        // Quiz Results Card
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "🎉", fontSize = 48.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "शाबाश! Quiz Complete!",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "تہنیت اور مبارکباد",
                        style = MaterialTheme.typography.titleMedium,
                        color = GoldAccent
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "Score: $score / ${questions.size * 10}",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "तपाईंले सफलताका साथ अभ्यास पूरा गर्नुभयो।",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { viewModel.restartQuiz() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Try Again (फेरि अभ्यास गर्नुहोस्)")
                    }
                }
            }
        }
        return
    }

    val currentQ = questions.getOrNull(currentIndex) ?: return

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // Progress & Score Bar
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Question ${currentIndex + 1} of ${questions.size}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.outline
                )
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "Score: $score XP",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            LinearProgressIndicator(
                progress = { (currentIndex + 1).toFloat() / questions.size },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp))
            )
        }

        // Question Prompt Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "سؤال",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        AudioSpeakerButton(
                            textToSpeak = currentQ.spokenText,
                            onSpeak = { viewModel.speak(it) },
                            isSpeaking = isSpeaking
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = currentQ.promptUrdu,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "🇳🇵 ${currentQ.promptNepali}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "🇬🇧 ${currentQ.promptEnglish}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }

        // Options
        items(currentQ.options.size) { optIdx ->
            val optionText = currentQ.options[optIdx]
            val isSelected = selectedOption == optIdx
            val isCorrect = optIdx == currentQ.correctOptionIndex

            val containerColor = when {
                !isAnswered && isSelected -> MaterialTheme.colorScheme.primaryContainer
                isAnswered && isCorrect -> Color(0xFF10B981).copy(alpha = 0.2f)
                isAnswered && isSelected && !isCorrect -> Color(0xFFEF4444).copy(alpha = 0.2f)
                else -> MaterialTheme.colorScheme.surface
            }

            val borderColor = when {
                !isAnswered && isSelected -> MaterialTheme.colorScheme.primary
                isAnswered && isCorrect -> Color(0xFF10B981)
                isAnswered && isSelected && !isCorrect -> Color(0xFFEF4444)
                else -> Color.Transparent
            }

            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = containerColor),
                border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(borderColor)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = !isAnswered) {
                        viewModel.onQuizSelectOption(optIdx)
                    }
                    .testTag("quiz_option_$optIdx")
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(
                                if (isSelected) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.surfaceVariant
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${'A' + optIdx}",
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Text(
                        text = optionText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                    if (isAnswered && isCorrect) {
                        Icon(Icons.Default.CheckCircle, contentDescription = "Correct", tint = Color(0xFF10B981))
                    } else if (isAnswered && isSelected && !isCorrect) {
                        Icon(Icons.Default.Cancel, contentDescription = "Wrong", tint = Color(0xFFEF4444))
                    }
                }
            }
        }

        // Explanation & Next Button
        item {
            AnimatedVisibility(visible = isAnswered) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "व्याख्या (Explanation):",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = currentQ.explanationNepali,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = currentQ.explanationEnglish,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = { viewModel.onQuizNextQuestion() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            if (currentIndex + 1 < questions.size) "Next Question ➔"
                            else "See Results 🎉"
                        )
                    }
                }
            }

            if (!isAnswered) {
                Button(
                    onClick = { viewModel.onQuizSubmitAnswer() },
                    enabled = selectedOption != null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("Submit Answer")
                }
            }
        }
    }
}

@Composable
fun FlashcardsPracticeView(
    viewModel: MainViewModel,
    isSpeaking: Boolean,
    currentLang: AppLanguage
) {
    val cardIndex by viewModel.flashcardIndex.collectAsState()
    val isFlipped by viewModel.isCardFlipped.collectAsState()
    val masteredCount by viewModel.masteredCards.collectAsState()

    val card = UrduRepository.vocabItems[cardIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Card ${cardIndex + 1} of ${UrduRepository.vocabItems.size}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF10B981).copy(alpha = 0.15f)
            ) {
                Text(
                    text = "Mastered: $masteredCount",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF047857),
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }

        // The Flashcard
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isFlipped) MaterialTheme.colorScheme.surfaceVariant
                else MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 20.dp)
                .clickable { viewModel.toggleCardFlip() }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    if (!isFlipped) {
                        Text(
                            text = "Tap to reveal meaning 🔄",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = card.urdu,
                            fontSize = 44.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        AudioSpeakerButton(
                            textToSpeak = card.urdu,
                            onSpeak = { viewModel.speak(it) },
                            isSpeaking = isSpeaking,
                            size = 52
                        )
                    } else {
                        Text(
                            text = card.urdu,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "उच्चारण: ${card.devanagari}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "(${card.romanUrdu})",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalDivider(modifier = Modifier.width(180.dp))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "🇳🇵 नेपाली: ${card.nepali}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "🇬🇧 English: ${card.english}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Action Buttons: Review vs Got It
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                onClick = { viewModel.nextFlashcard(mastered = false) },
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
            ) {
                Icon(Icons.Default.Refresh, contentDescription = null)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Review Again")
            }
            Button(
                onClick = { viewModel.nextFlashcard(mastered = true) },
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
            ) {
                Icon(Icons.Default.Check, contentDescription = null)
                Spacer(modifier = Modifier.width(6.dp))
                Text("I Know This!")
            }
        }
    }
}

@Composable
fun ListeningPracticeView(
    viewModel: MainViewModel,
    isSpeaking: Boolean,
    currentLang: AppLanguage
) {
    var roundIndex by remember { mutableStateOf(0) }
    var selectedMatch by remember { mutableStateOf<Int?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }

    val listeningPool = UrduRepository.vocabItems.take(6)
    val currentTarget = listeningPool[roundIndex % listeningPool.size]

    val options = remember(roundIndex) {
        val others = listeningPool.filter { it.id != currentTarget.id }.shuffled().take(3)
        (others + currentTarget).shuffled()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Listen carefully to the spoken Urdu:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                AudioSpeakerButton(
                    textToSpeak = currentTarget.urdu,
                    onSpeak = { viewModel.speak(it) },
                    isSpeaking = isSpeaking,
                    size = 64
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Tap speaker to hear audio",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }

        Text(
            text = "Select the correct translation:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        options.forEachIndexed { idx, opt ->
            val isSelected = selectedMatch == idx
            val isCorrect = opt.id == currentTarget.id

            val cardColor = when {
                !isSubmitted && isSelected -> MaterialTheme.colorScheme.primaryContainer
                isSubmitted && isCorrect -> Color(0xFF10B981).copy(alpha = 0.2f)
                isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444).copy(alpha = 0.2f)
                else -> MaterialTheme.colorScheme.surface
            }

            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = cardColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = !isSubmitted) { selectedMatch = idx }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "🇳🇵 ${opt.nepali}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "🇬🇧 ${opt.english}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                    if (isSubmitted && isCorrect) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF10B981))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        if (!isSubmitted) {
            Button(
                onClick = { isSubmitted = true },
                enabled = selectedMatch != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Check Answer")
            }
        } else {
            Button(
                onClick = {
                    isSubmitted = false
                    selectedMatch = null
                    roundIndex += 1
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Next Audio Challenge ➔")
            }
        }
    }
}
