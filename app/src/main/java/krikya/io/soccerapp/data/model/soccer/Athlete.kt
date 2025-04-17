package krikya.io.soccerapp.data.model.soccer

data class Athlete(
    val active: Boolean,
    val displayName: String,
    val fullName: String,
    val headshot: String,
    val id: String,
    val jersey: String,
    val links: List<Link>,
    val position: Position,
    val shortName: String,
    val team: TeamX
)