package com.example.omgupsandroidapp.data.schedule.room

import com.example.omgupsandroidapp.data.local.Room.Cache.DataScheduleDao
import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto
import com.example.omgupsandroidapp.data.schedule.ScheduleLocalDataSourse

class RoomScheduleDataSourse(private val dataScheduleDao : DataScheduleDao) : ScheduleLocalDataSourse {
    override suspend fun loadAllSchedule(): List<ScheduleEntity>/*List<ScheduleEntity>*/ = dataScheduleDao.getScheduleFromHost()
    override suspend fun saveRemouteRespons(response: List<ScheduleEntity>) {
        return dataScheduleDao.saveAllSchedule(response.map {
            ScheduleEntity(
                day_of_week = it.day_of_week,
                //guid = it.guid,
                id = it.id,
                sgroup = it.sgroup,
                subj = it.subj,
                time = it.time,
                type_of_week = it.type_of_week
            )
            }
        )
    }

    override suspend fun clearLocalSchedule() = dataScheduleDao.deleteAllSchedule()
}