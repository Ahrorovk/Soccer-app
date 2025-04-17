package krikya.io.soccerapp.data.model.soccer

data class PointSpread(
    val away: AwayX,
    val displayName: String,
    val home: HomeX,
    val shortDisplayName: String
)