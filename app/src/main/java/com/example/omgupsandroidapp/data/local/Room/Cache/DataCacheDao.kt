package com.example.omgupsandroidapp.data.local.Room.Cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto

@Dao
interface DataScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(data: ScheduleEntity)

    @Query("SELECT * FROM schedule")
    fun getScheduleFromHost(): List<ScheduleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun saveAllSchedule(entity: List<ScheduleEntity>)

    @Query("DELETE FROM schedule")
    suspend fun deleteAllSchedule()
    /*@Query("SELECT * FROM data_cache WHERE url = :url")
    suspend fun getCache(url: String): DataCache?*/
}