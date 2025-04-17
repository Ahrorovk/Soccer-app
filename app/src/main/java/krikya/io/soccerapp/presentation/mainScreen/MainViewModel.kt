package krikya.io.soccerapp.presentation.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.plus
import krikya.io.soccerapp.core.Resource
import krikya.io.soccerapp.domain.state.EventResponseState
import krikya.io.soccerapp.domain.use_case.GetScoreboardUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getScoreboardUseCase: GetScoreboardUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.stateIn(
        viewModelScope + Dispatchers.IO,
        SharingStarted.WhileSubscribed(5000L),
        MainState()
    )

    fun onEvent(event: MainEvent) {
        when (event) {
            else -> Unit
        }
    }

    fun getScoreboard() {
        getScoreboardUseCase.invoke(_state.value.selectLeague).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val response = result.data?.events
                    _state.update {
                        it.copy(
                            eventResponseState = EventResponseState(response = response)
                        )
                    }
                }

                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            eventResponseState = EventResponseState(error = result.message.toString())
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            eventResponseState = EventResponseState(loading = true)
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}