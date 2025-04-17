package krikya.io.soccerapp.presentation.mainScreen

import krikya.io.soccerapp.domain.state.EventResponseState

data class MainState(
    val selectLeague:String = "usa.1",
    val eventResponseState: EventResponseState = EventResponseState()
)
