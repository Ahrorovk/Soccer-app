package krikya.io.soccerapp.app.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import krikya.io.soccerapp.core.Routes
import krikya.io.soccerapp.presentation.mainScreen.MainScreen
import krikya.io.soccerapp.presentation.mainScreen.MainViewModel
import krikya.io.soccerapp.presentation.splashScreen.SplashEvent
import krikya.io.soccerapp.presentation.splashScreen.SplashScreen
import krikya.io.soccerapp.presentation.splashScreen.SplashViewModel
import krikya.io.soccerapp.presentation.startScreen.StartEvent
import krikya.io.soccerapp.presentation.startScreen.StartScreen
import krikya.io.soccerapp.presentation.startScreen.StartViewModel


@Composable
fun Navigation(
    state: NavigationState,
    onEvent: (NavigationEvent) -> Unit
) {
    val navController = rememberNavController()
    Scaffold { it_ ->
        NavHost(navController, startDestination = Routes.SplashScreen.route) {
            composable(Routes.SplashScreen.route) {
                val viewModel = hiltViewModel<SplashViewModel>()
                val state = viewModel.state.collectAsState()
                SplashScreen(state.value) { event ->
                    when (event) {
                        SplashEvent.GoToStart -> {
                            navController.navigate(Routes.StartScreen.route) {
                                popUpTo(Routes.SplashScreen.route) {
                                    inclusive = true
                                }
                            }
                        }

                        else -> viewModel.state
                    }
                }
            }
            composable(Routes.StartScreen.route) {
                val viewModel = hiltViewModel<StartViewModel>()
                val state = viewModel.state.collectAsState()
                StartScreen(state.value) { event ->
                    when (event) {
                        StartEvent.GoToMain -> {
                            navController.navigate(Routes.MainScreen.route) {
                                popUpTo(Routes.StartScreen.route) {
                                    inclusive = true
                                }
                            }
                        }

                        else -> viewModel.state
                    }
                }
            }
            composable(Routes.MainScreen.route) {
                val viewModel = hiltViewModel<MainViewModel>()
                val state = viewModel.state.collectAsState()
                MainScreen(state.value) { event ->
                    when (event) {

                        else -> viewModel.onEvent(event)
                    }
                }
            }
        }
    }
}
