package krikya.io.soccerapp.data.model.soccer

data class LinkX(
    val href: String,
    val isExternal: Boolean,
    val isHidden: Boolean,
    val isPremium: Boolean,
    val rel: List<String>,
    val text: String
)