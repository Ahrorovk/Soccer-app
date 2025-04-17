package krikya.io.soccerapp.presentation.mainScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import krikya.io.soccerapp.presentation.components.CustomCircularProgressIndicator

@Composable
fun MainScreen(
    state: MainState,
    onEvent: (MainEvent) -> Unit
) {
    LaunchedEffect(true) {
        onEvent(MainEvent.GetScoreboard)
    }
    CustomCircularProgressIndicator(state.eventResponseState.loading)
}