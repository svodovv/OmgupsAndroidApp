package com.example.omgupsandroidapp.data.schedule

import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto

interface ScheduleLocalDataSourse {

     suspend fun loadAllSchedule(): List<ScheduleEntity>//SheduleDto//List<ScheduleEntity>
     suspend fun saveRemouteRespons(response : List<ScheduleEntity>)
     suspend fun clearLocalSchedule()
}