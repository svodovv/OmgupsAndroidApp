package com.example.omgupsandroidapp.data.schedule

import android.app.AppComponentFactory
import android.content.Context
import com.example.fooddeliverygosport.di.interceptors.OnlineInterceptor
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.data.schedule.retrofit.RetrofitScheduleDataSourseval
import com.example.omgupsandroidapp.data.schedule.room.RoomScheduleDataSourse
import com.omgupsapp.data.local.Room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ScheduleDataModule {

    @Provides
    @Singleton
    fun provideLocalDataSourse(roomDataBase: AppDatabase): ScheduleLocalDataSourse =
        RoomScheduleDataSourse(roomDataBase.dataScheduleDao())

    @Provides
    @Singleton
    fun provideRemoteDataSourse( serviceApi: ServiceApi): ScheduleRemoteDataSourse = RetrofitScheduleDataSourseval(serviceApi)

    @Provides
    @Singleton
    fun provideScheduleRepository(
        local : ScheduleLocalDataSourse,
        remote : ScheduleRemoteDataSourse,
        interceptor: OnlineInterceptor,
        @ApplicationContext context: Context
    ): ScheduleRepository =
        ScheduleRepository(local,remote,interceptor,context)

}