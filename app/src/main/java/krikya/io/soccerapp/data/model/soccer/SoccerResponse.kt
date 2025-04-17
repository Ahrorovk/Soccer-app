package krikya.io.soccerapp.data.model.soccer

data class SoccerResponse(
    val day: Day,
    val events: List<Event>,
    val leagues: List<League>,
    val season: SeasonXX
)