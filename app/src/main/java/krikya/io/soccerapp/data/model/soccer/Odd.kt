package krikya.io.soccerapp.data.model.soccer

data class Odd(
    val awayTeamOdds: AwayTeamOdds,
    val details: String,
    val drawOdds: DrawOdds,
    val homeTeamOdds: HomeTeamOdds,
    val link: LinkXXXXXXXXXXXXXX,
    val moneyline: Moneyline,
    val overUnder: Double,
    val pointSpread: PointSpread,
    val provider: Provider,
    val total: Total
)