package krikya.io.soccerapp.presentation.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import krikya.io.soccerapp.R

@Composable
fun SplashScreen(
    state: SplashState,
    onEvent: (SplashEvent) -> Unit
) {
    val gradientColors = listOf(
        Color(0xFF6FC59D),
        Color(0xFF378F6A)
    )
    LaunchedEffect(true) {
        delay(5000L)
        onEvent(SplashEvent.GoToStart)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = gradientColors,
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(0.75f),
            painter = painterResource(R.drawable.logo), contentDescription = "splash_logo"
        )
    }
}

@Preview
@Composable
fun preview() {
    val viewModel = hiltViewModel<SplashViewModel>()
    val state = viewModel.state.collectAsState()
    SplashScreen(state.value){ event ->
        when(event){
            SplashEvent.GoToStart -> TODO()
            else -> viewModel.state
        }
    }
}