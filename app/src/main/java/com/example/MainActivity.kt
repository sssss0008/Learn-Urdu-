package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.ui.components.*
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearnScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                UrduBhashaApp(viewModel = viewModel)
            }
        }
    }
}

data class NavTabItem(
    val titleEnglish: String,
    val titleNepali: String,
    val titleUrdu: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val testTag: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UrduBhashaApp(viewModel: MainViewModel) {
    val currentTab by viewModel.currentTab.collectAsState()
    val currentLang by viewModel.currentLanguage.collectAsState()
    val selectedArticle by viewModel.selectedArticle.collectAsState()
    val selectedSher by viewModel.selectedSher.collectAsState()
    val isSpeaking by viewModel.ttsManager.isSpeaking.collectAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var showFeedbackDialog by remember { mutableStateOf(false) }

    val navItems = listOf(
        NavTabItem("Home", "गृहपृष्ठ", "ہوم", Icons.Filled.Home, Icons.Outlined.Home, "nav_home"),
        NavTabItem("Learn", "सिक्नुहोस्", "سیکھیں", Icons.Filled.MenuBook, Icons.Outlined.MenuBook, "nav_learn"),
        NavTabItem("Practice", "अभ्यास", "مشق", Icons.Filled.Quiz, Icons.Outlined.Quiz, "nav_practice"),
        NavTabItem("About", "विवरण", "تفصیلات", Icons.Filled.Info, Icons.Outlined.Info, "nav_about")
    )

    // Handle back button: close drawer or return to Home tab
    BackHandler(enabled = drawerState.isOpen || currentTab != 0) {
        if (drawerState.isOpen) {
            coroutineScope.launch { drawerState.close() }
        } else if (currentTab != 0) {
            viewModel.setTab(0)
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            UrduNavigationDrawerContent(
                viewModel = viewModel,
                onCloseDrawer = { coroutineScope.launch { drawerState.close() } },
                onOpenFeedback = { showFeedbackDialog = true }
            )
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "اردو",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = GoldAccent
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = when (currentLang) {
                                    AppLanguage.URDU -> "اردو بھاشا"
                                    AppLanguage.NEPALI -> "उर्दू भाषा"
                                    AppLanguage.ENGLISH -> "Urdu Bhasha"
                                },
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { coroutineScope.launch { drawerState.open() } },
                            modifier = Modifier.testTag("open_drawer_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Open Cultural & History Drawer"
                            )
                        }
                    },
                    actions = {
                        LanguageSelectorPill(
                            currentLanguage = currentLang,
                            onLanguageChange = { viewModel.setLanguage(it) }
                        )
                        IconButton(
                            onClick = { showFeedbackDialog = true },
                            modifier = Modifier.testTag("app_bar_feedback_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Feedback,
                                contentDescription = "Feedback & Contact",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp,
                    windowInsets = WindowInsets.navigationBars
                ) {
                    navItems.forEachIndexed { index, item ->
                        val isSelected = currentTab == index
                        val label = when (currentLang) {
                            AppLanguage.URDU -> item.titleUrdu
                            AppLanguage.NEPALI -> item.titleNepali
                            AppLanguage.ENGLISH -> item.titleEnglish
                        }

                        NavigationBarItem(
                            selected = isSelected,
                            onClick = { viewModel.setTab(index) },
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = label
                                )
                            },
                            label = {
                                Text(
                                    text = label,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            alwaysShowLabel = true,
                            modifier = Modifier.testTag(item.testTag)
                        )
                    }
                }
            },
            contentWindowInsets = WindowInsets.safeDrawing
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Crossfade(targetState = currentTab, label = "tab_fade") { tab ->
                    when (tab) {
                        0 -> HomeScreen(viewModel = viewModel)
                        1 -> LearnScreen(viewModel = viewModel)
                        2 -> PracticeScreen(viewModel = viewModel)
                        3 -> AboutScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }

    // Cultural Article Dialog from Drawer or Home
    selectedArticle?.let { article ->
        CulturalArticleDetailDialog(
            article = article,
            onDismiss = { viewModel.selectArticle(null) },
            currentLang = currentLang,
            onSpeak = { viewModel.speak(it) },
            isSpeaking = isSpeaking
        )
    }

    // Poetry Sher Detail Dialog
    selectedSher?.let { sher ->
        PoetrySherDetailDialog(
            sher = sher,
            onDismiss = { viewModel.selectSher(null) },
            onSpeak = { viewModel.speak(it, slow = true) },
            isSpeaking = isSpeaking
        )
    }

    // Feedback Dialog
    if (showFeedbackDialog) {
        FeedbackContactDialog(onDismiss = { showFeedbackDialog = false })
    }
}
