package krikya.io.soccerapp.presentation.startScreen

sealed class StartEvent {
    object GoToMain : StartEvent()
}