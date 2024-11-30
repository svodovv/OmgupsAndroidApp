package com.example.omgupsandroidapp.data.schedule

import android.content.Context
import android.database.Observable
import com.example.fooddeliverygosport.di.interceptors.OnlineInterceptor
import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.local.Room.Cache.mapToRemote
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto
import com.example.omgupsandroidapp.data.remote.dto.schedule.toSheduleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleRepository(
    private val scheduleLocalDataSourse: ScheduleLocalDataSourse,
    private val scheduleRemoteDataSourse: ScheduleRemoteDataSourse,
    private val onlineInterceptor: OnlineInterceptor,
    private val context: Context
) {



    suspend fun fetchSchedule(): List<ScheduleEntity> = withContext(Dispatchers.IO)
    {
        if (onlineInterceptor.isNetworkAvailable(context)) {
            scheduleLocalDataSourse.clearLocalSchedule()
            val resSave = scheduleRemoteDataSourse.getSchedule()
            scheduleLocalDataSourse.saveRemouteRespons(resSave)
            val resLocal =  scheduleLocalDataSourse.loadAllSchedule().map {
                it
            }
            return@withContext resLocal
        }else {
            val resLocal = scheduleLocalDataSourse.loadAllSchedule().map {
                it
            }
            return@withContext resLocal
        }
    }

}