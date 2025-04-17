package krikya.io.soccerapp.data.model.soccer

data class Competition(
    val attendance: Int,
    val broadcast: String,
    val broadcasts: List<Broadcast>,
    val competitors: List<Competitor>,
    val date: String,
    val details: List<Any?>,
    val format: Format,
    val geoBroadcasts: List<GeoBroadcast>,
    val id: String,
    val notes: List<Any?>,
    val odds: List<Odd>,
    val playByPlayAthletes: Boolean,
    val playByPlayAvailable: Boolean,
    val recent: Boolean,
    val startDate: String,
    val status: StatusX,
    val tickets: List<Ticket>,
    val timeValid: Boolean,
    val uid: String,
    val venue: VenueX,
    val wasSuspended: Boolean
)