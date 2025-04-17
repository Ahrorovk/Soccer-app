package krikya.io.soccerapp.data.network

import krikya.io.soccerapp.core.Constants.apiKey
import krikya.io.soccerapp.data.model.soccer.SoccerResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface SoccerApi {
    @GET("sports/soccer/{leagueId}/scoreboard")
    suspend fun getScoreboard(
        @Path("leagueId", encoded = true)
        leagueId: String,                  // e.g. "usa.1", "eng.1", "fra.1"
    ): SoccerResponse

}