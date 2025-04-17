package krikya.io.soccerapp.core

sealed class Routes(val route: String) {
    object SplashScreen : Routes("SplashScreen")
    object StartScreen : Routes("StartScreen")
    object MainScreen : Routes("MainScreen")
}