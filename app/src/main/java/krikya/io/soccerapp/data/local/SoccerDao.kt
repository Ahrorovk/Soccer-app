package krikya.io.soccerapp.data.local

import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import krikya.io.soccerapp.data.model.entity.SoccerEntity

interface SoccerDao : BaseDao<SoccerEntity> {
    @Query("SELECT * FROM ${SoccerEntity.TABLE_NAME} WHERE id = :id")
    suspend fun getById(id: Int): SoccerEntity?
}