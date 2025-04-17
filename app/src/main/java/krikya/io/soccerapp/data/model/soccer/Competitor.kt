package krikya.io.soccerapp.data.model.soccer

data class Competitor(
    val form: String,
    val homeAway: String,
    val id: String,
    val leaders: List<Leader>,
    val order: Int,
    val records: List<Record>,
    val score: String,
    val statistics: List<Any?>,
    val team: TeamXX,
    val type: String,
    val uid: String,
    val winner: Boolean
)