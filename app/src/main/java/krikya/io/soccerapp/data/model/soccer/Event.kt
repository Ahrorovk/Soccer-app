package krikya.io.soccerapp.data.model.soccer

data class Event(
    val competitions: List<Competition>,
    val date: String,
    val id: String,
    val links: List<LinkXXXXXXXXXXXXXX>,
    val name: String,
    val season: Season,
    val shortName: String,
    val status: StatusX,
    val uid: String,
    val venue: VenueXX
)