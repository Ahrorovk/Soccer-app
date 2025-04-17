package krikya.io.soccerapp.data.model.soccer

data class Moneyline(
    val away: Away,
    val displayName: String,
    val draw: Draw,
    val home: Home,
    val shortDisplayName: String
)