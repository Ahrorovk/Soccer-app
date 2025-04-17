package krikya.io.soccerapp.data.model.soccer

data class Link(
    val href: String,
    val isHidden: Boolean,
    val rel: List<String>
)