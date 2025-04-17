package krikya.io.soccerapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import krikya.io.soccerapp.app.navigation.Navigation
import krikya.io.soccerapp.app.navigation.NavigationViewModel
import krikya.io.soccerapp.app.ui.theme.SoccerAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoccerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = hiltViewModel<NavigationViewModel>()
                    val state = viewModel.state.collectAsState()
                    Navigation(
                        state = state.value,
                        onEvent = { event ->
                            when (event) {
                                else -> viewModel.onEvent(event)
                            }
                        }
                    )
                }
            }
        }
    }
}
