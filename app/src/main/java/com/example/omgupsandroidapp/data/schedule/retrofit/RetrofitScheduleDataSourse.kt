package com.example.omgupsandroidapp.data.schedule.retrofit

import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto
import com.example.omgupsandroidapp.data.schedule.ScheduleRemoteDataSourse

class RetrofitScheduleDataSourseval (val serviceApi: ServiceApi): ScheduleRemoteDataSourse
{
    override suspend fun getSchedule(): List<ScheduleEntity> = serviceApi.getShudule()

}