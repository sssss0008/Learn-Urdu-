package com.example.ui.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.data.repository.UrduRepository
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.components.MughalHeritageHeroBanner
import com.example.ui.theme.GoldAccent
import com.example.ui.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val currentLang by viewModel.currentLanguage.collectAsState()
    val isSpeaking by viewModel.ttsManager.isSpeaking.collectAsState()
    val streakDays by viewModel.streakDays.collectAsState()
    val wordsLearned by viewModel.wordsLearnedCount.collectAsState()

    val wordOfTheDay = UrduRepository.getWordOfTheDay()
    val sherOfTheDay = UrduRepository.getSherOfTheDay()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp)
    ) {
        // Hero Cultural Banner
        item {
            MughalHeritageHeroBanner(
                title = when (currentLang) {
                    AppLanguage.URDU -> "اردو زبان سیکھیں"
                    AppLanguage.NEPALI -> "उर्दू भाषा र संस्कृति"
                    AppLanguage.ENGLISH -> "Learn Urdu Bhasha"
                },
                subtitle = when (currentLang) {
                    AppLanguage.URDU -> "نیپالی اور انگریزی میں اردو سیکھنے کا آسان ذریعہ"
                    AppLanguage.NEPALI -> "नेपाली र अङ्ग्रेजीमा उर्दू सिक्ने सरल माध्यम"
                    AppLanguage.ENGLISH -> "The elegant trilingual path to mastering Urdu"
                }
            )
        }

        // Learning Stats Card
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StatItem(
                        icon = Icons.Default.LocalFireDepartment,
                        iconColor = Color(0xFFEA580C),
                        value = "$streakDays Days",
                        label = when (currentLang) {
                            AppLanguage.URDU -> "مسلسل سلسلہ"
                            AppLanguage.NEPALI -> "दैनिक निरन्तरता"
                            AppLanguage.ENGLISH -> "Day Streak"
                        }
                    )
                    VerticalDivider(modifier = Modifier.height(36.dp))
                    StatItem(
                        icon = Icons.Default.MenuBook,
                        iconColor = MaterialTheme.colorScheme.primary,
                        value = "$wordsLearned",
                        label = when (currentLang) {
                            AppLanguage.URDU -> "سیکھے گئے الفاظ"
                            AppLanguage.NEPALI -> "सिकिएका शब्द"
                            AppLanguage.ENGLISH -> "Words Mastered"
                        }
                    )
                    VerticalDivider(modifier = Modifier.height(36.dp))
                    StatItem(
                        icon = Icons.Default.EmojiEvents,
                        iconColor = GoldAccent,
                        value = "Level 1",
                        label = when (currentLang) {
                            AppLanguage.URDU -> "سطح"
                            AppLanguage.NEPALI -> "तह"
                            AppLanguage.ENGLISH -> "Proficiency"
                        }
                    )
                }
            }
        }

        // Word of the Day (لفظ روز)
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
                ),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = Brush.horizontalGradient(
                        colors = listOf(MaterialTheme.colorScheme.primary, GoldAccent)
                    )
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = when (currentLang) {
                                    AppLanguage.URDU -> "لفظِ روز"
                                    AppLanguage.NEPALI -> "आजको शब्द (Word of the Day)"
                                    AppLanguage.ENGLISH -> "Word of the Day"
                                },
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        AudioSpeakerButton(
                            textToSpeak = wordOfTheDay.urdu,
                            onSpeak = { viewModel.speak(it) },
                            isSpeaking = isSpeaking
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = wordOfTheDay.urdu,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "उच्चारण: ${wordOfTheDay.devanagari}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                        Text(
                            text = "(${wordOfTheDay.romanUrdu})",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "नेपाली अर्थ: ${wordOfTheDay.nepali}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "English: ${wordOfTheDay.english}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    if (wordOfTheDay.exampleUrdu != null) {
                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "مثال: ${wordOfTheDay.exampleUrdu}",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "(${wordOfTheDay.exampleNepali})",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Sher of the Day (شعر روز)
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.selectSher(sherOfTheDay) }
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "📜", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = when (currentLang) {
                                    AppLanguage.URDU -> "شعرِ روز"
                                    AppLanguage.NEPALI -> "आजको शेर (Poetic Couplet)"
                                    AppLanguage.ENGLISH -> "Sher of the Day"
                                },
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        AudioSpeakerButton(
                            textToSpeak = "${sherOfTheDay.misra1Urdu} ... ${sherOfTheDay.misra2Urdu}",
                            onSpeak = { viewModel.speak(it, slow = true) },
                            isSpeaking = isSpeaking
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                            .padding(14.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = sherOfTheDay.misra1Urdu,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = sherOfTheDay.misra2Urdu,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "देवनागरी: ${sherOfTheDay.devanagariTransliteration.replace("\n", " / ")}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "नेपाली भावार्थ: ${sherOfTheDay.translationNepali.replace("\n", " ")}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "— ${sherOfTheDay.poetNameNepali} (${sherOfTheDay.poetNameUrdu})",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = GoldAccent
                        )
                    }
                }
            }
        }

        // Quick Launch Grid
        item {
            Text(
                text = when (currentLang) {
                    AppLanguage.URDU -> "تیز رفتار رسائی"
                    AppLanguage.NEPALI -> "छिटो पहुँच (Explore Modules)"
                    AppLanguage.ENGLISH -> "Quick Explore"
                },
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickCard(
                    title = "Alphabet (ا ب پ)",
                    subtitle = "39 Letters",
                    icon = Icons.Default.FontDownload,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.setLearnSubTab(0)
                        viewModel.setTab(1)
                    }
                )
                QuickCard(
                    title = "Vocabulary",
                    subtitle = "8 Categories",
                    icon = Icons.Default.MenuBook,
                    color = Color(0xFFB45309),
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.setLearnSubTab(1)
                        viewModel.setTab(1)
                    }
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickCard(
                    title = "Interactive Quiz",
                    subtitle = "Test & Earn XP",
                    icon = Icons.Default.Quiz,
                    color = Color(0xFF9F2B48),
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.setPracticeMode(0)
                        viewModel.setTab(2)
                    }
                )
                QuickCard(
                    title = "Flashcards",
                    subtitle = "Quick Review",
                    icon = Icons.Default.Style,
                    color = Color(0xFF0D9488),
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.setPracticeMode(1)
                        viewModel.setTab(2)
                    }
                )
            }
        }

        // Cultural Heritage Spotlight
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.selectArticle(UrduRepository.culturalArticles.first())
                    }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🏛️", fontSize = 26.sp)
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Cultural Heritage (ثقافتی ورثہ)",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "उर्दूको इतिहास र नस्तालिक कला",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "दक्कनदेखि लखनउसम्मको साहित्यिक यात्रा पढ्नुहोस्",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Read More",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun StatItem(
    icon: ImageVector,
    iconColor: Color,
    value: String,
    label: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
fun QuickCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.12f)),
        border = CardDefaults.outlinedCardBorder().copy(brush = Brush.horizontalGradient(listOf(color.copy(alpha = 0.4f), color.copy(alpha = 0.2f)))),
        modifier = modifier.clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
