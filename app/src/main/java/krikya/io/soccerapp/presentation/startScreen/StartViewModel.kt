package krikya.io.soccerapp.presentation.startScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(StartState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        StartState()
    )

    fun onEvent(event: StartEvent) {
        when (event) {
            else -> Unit
        }
    }
}