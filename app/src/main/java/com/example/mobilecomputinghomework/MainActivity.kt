package com.example.mobilecomputinghomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mobilecomputinghomework.ui.theme.MobileComputingHomeworkTheme
import kotlinx.serialization.Serializable

@Serializable
object Main
@Serializable
object Settings
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileComputingHomeworkTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Main
                ) {
                    composable<Main> {
                        MainScreen(
                            onNavigateToSettings = {
                                navController.navigate(route = Settings) {
                                    popUpTo(Settings) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                    composable<Settings> {
                        SettingsScreen(
                            onNavigateToMain = {
                                navController.navigate(route = Main) {
                                    popUpTo(Main) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
