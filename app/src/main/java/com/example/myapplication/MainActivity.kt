package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.model.SplashViewModel
import com.example.myapplication.navigation.BottomNav
import com.example.myapplication.navigation.NavGraph
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }

        setContent {
            MyApplicationTheme {
                val navController =
                    rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNav(
                            navController = navController
                        )
                    }
                ) { paddingValue ->
                        NavGraph(
                            modifier = Modifier.padding(
                                paddingValue
                            ),
                            navController = navController
                        )
                }
            }
        }
    }
}