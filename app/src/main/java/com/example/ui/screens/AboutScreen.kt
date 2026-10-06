package com.example.ui.screens

import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.FeedbackContactDialog
import com.example.ui.components.copyToClipboard
import com.example.ui.theme.GoldAccent
import com.example.ui.viewmodel.MainViewModel

@Composable
fun AboutScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var showFeedbackDialog by remember { mutableStateOf(false) }

    val email = "awiskaracharya@gmail.com"
    val phone = "+9779827106244"
    val linkedin = "https://www.linkedin.com/in/awiskaracharya/"

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 32.dp)
    ) {
        // App Header Brand Card
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(76.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(Color(0xFF064E3B), Color(0xFF047857))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "اردو",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldAccent
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Urdu Bhasha",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "उर्दू भाषा र साहित्य सिकाई एप",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = "Version 1.0.0 • Trilingual Edition",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "A comprehensive, beautifully designed learning experience connecting Nepali, English, and global learners to the poetic grace, script, and cultural heritage of the Urdu language.",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Developer & Feedback Section (Prompt Requirement)
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                ),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = Brush.horizontalGradient(
                        listOf(MaterialTheme.colorScheme.primary, GoldAccent)
                    )
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.ContactSupport,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Developer & Feedback",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "We cherish user feedback, ideas, and collaborations. Reach out directly to the developer:",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Email Item
                    DeveloperContactTile(
                        icon = Icons.Default.Email,
                        title = "Email Address",
                        detail = email,
                        actionText = "Send Email",
                        onAction = {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:$email")
                                putExtra(Intent.EXTRA_SUBJECT, "Urdu Bhasha App Feedback & Inquiry")
                            }
                            try {
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                copyToClipboard(context, email, "Email copied: $email")
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Phone Item
                    DeveloperContactTile(
                        icon = Icons.Default.Phone,
                        title = "Phone / WhatsApp",
                        detail = phone,
                        actionText = "Call / Copy",
                        onAction = {
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                            try {
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                copyToClipboard(context, phone, "Phone copied: $phone")
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // LinkedIn Item
                    DeveloperContactTile(
                        icon = Icons.Default.Share,
                        title = "LinkedIn Profile",
                        detail = "linkedin.com/in/awiskaracharya",
                        actionText = "Open Profile",
                        onAction = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedin))
                            try {
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                copyToClipboard(context, linkedin, "LinkedIn URL copied")
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { showFeedbackDialog = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("open_feedback_dialog_btn")
                    ) {
                        Icon(Icons.Default.RateReview, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Rate & Send In-App Feedback")
                    }
                }
            }
        }

        // Key Features Breakdown
        item {
            Text(
                text = "Key Highlights",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(10.dp))

            FeatureBullet(
                icon = "🌐",
                title = "Trilingual Support (Urdu, Nepali & English)",
                description = "Every phrase, letter, and concept is mapped to Devanagari pronunciation and Nepali/English meanings."
            )
            FeatureBullet(
                icon = "🎙️",
                title = "Crystal-Clear Audio Pronunciation",
                description = "Integrated Android Text-To-Speech engine allows you to hear native Urdu phonetics at your own pace."
            )
            FeatureBullet(
                icon = "📜",
                title = "Classical Urdu Poetry & Literature",
                description = "Explore immortal verses from Mirza Ghalib, Allama Iqbal, Faiz Ahmed Faiz, and Mir Taqi Mir."
            )
            FeatureBullet(
                icon = "✍️",
                title = "Nastaliq Script & Calligraphy",
                description = "Learn how connected letters flow from right to left with initial, medial, and final forms."
            )
            FeatureBullet(
                icon = "🎯",
                title = "Interactive Practice Modes",
                description = "Engage in timed quizzes, 3D flip flashcards, and audio listening challenges with instant scoring."
            )
        }

        // Legal & Attribution
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Built with Modern Android Architecture",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Jetpack Compose, Kotlin Coroutines, StateFlow, Material Design 3, Android TextToSpeech.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }

    if (showFeedbackDialog) {
        FeedbackContactDialog(onDismiss = { showFeedbackDialog = false })
    }
}

@Composable
fun DeveloperContactTile(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    detail: String,
    actionText: String,
    onAction: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                    Text(
                        text = detail,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            FilledTonalButton(
                onClick = onAction,
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
                modifier = Modifier.height(34.dp)
            ) {
                Text(text = actionText, fontSize = 11.sp)
            }
        }
    }
}

@Composable
fun FeatureBullet(
    icon: String,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(text = icon, fontSize = 20.sp, modifier = Modifier.padding(top = 2.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
