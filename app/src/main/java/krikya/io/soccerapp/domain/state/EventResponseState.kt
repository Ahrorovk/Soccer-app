package krikya.io.soccerapp.domain.state

import krikya.io.soccerapp.data.model.soccer.Event

data class EventResponseState(
    val response: List<Event>? = null,
    val error: String = "",
    val loading: Boolean = false
)
