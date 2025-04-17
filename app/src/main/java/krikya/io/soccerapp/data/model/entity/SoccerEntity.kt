package krikya.io.soccerapp.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(SoccerEntity.TABLE_NAME)
data class SoccerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TABLE_ID) val id: Int? = null,
    @ColumnInfo(name = TABLE_NOTE) val note: String
) {
    companion object {
        const val TABLE_NAME = "user_table"
        const val TABLE_ID = "id"
        const val TABLE_NOTE = "note"
    }
}