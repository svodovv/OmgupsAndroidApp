package com.example.omgupsandroidapp.data.schedule

import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto

interface ScheduleRemoteDataSourse{
    suspend fun getSchedule(): List<ScheduleEntity>
}