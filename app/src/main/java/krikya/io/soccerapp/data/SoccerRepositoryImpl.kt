package krikya.io.soccerapp.data

import krikya.io.soccerapp.data.local.SoccerDao
import krikya.io.soccerapp.data.model.entity.SoccerEntity
import krikya.io.soccerapp.data.model.soccer.SoccerResponse
import krikya.io.soccerapp.data.network.SoccerApi
import krikya.io.soccerapp.domain.SoccerRepository
import javax.inject.Inject

class SoccerRepositoryImpl @Inject constructor(
    private val soccerApi: SoccerApi,
    private val soccerDao: SoccerDao
) : SoccerRepository {

    override suspend fun getScoreboard(leagueId: String): SoccerResponse =
        soccerApi.getScoreboard(leagueId)

    override suspend fun getGameByIdFromDB(id: Int): SoccerEntity? = soccerDao.getById(id)
}