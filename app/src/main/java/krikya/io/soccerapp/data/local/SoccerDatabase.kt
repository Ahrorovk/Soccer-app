package krikya.io.soccerapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import krikya.io.soccerapp.data.model.entity.SoccerEntity

@Database(
    entities = [SoccerEntity::class],
    version = 1
)
abstract class SoccerDatabase : RoomDatabase() {
    abstract fun soccerDao(): SoccerDao
}