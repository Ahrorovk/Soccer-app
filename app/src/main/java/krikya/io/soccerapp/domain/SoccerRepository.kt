package krikya.io.soccerapp.domain

import krikya.io.soccerapp.data.model.entity.SoccerEntity
import krikya.io.soccerapp.data.model.soccer.SoccerResponse


interface SoccerRepository {
    suspend fun getScoreboard(
        leagueId: String
    ): SoccerResponse

    suspend fun getGameByIdFromDB(id: Int): SoccerEntity?
}