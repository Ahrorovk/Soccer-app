package krikya.io.soccerapp.data.network

import krikya.io.soccerapp.data.model.soccer.SoccerResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SoccerApi {
    @GET("apis/site/v2/sports/soccer/{leagueId}/scoreboard")
    suspend fun getScoreboard(
        @Path("leagueId", encoded = true)
        leagueId: String,                  // e.g. "usa.1", "eng.1", "fra.1"
    ): SoccerResponse

}