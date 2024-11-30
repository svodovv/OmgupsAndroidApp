package com.omgupsapp.di

import android.content.Context
import androidx.room.Room
import com.example.omgupsandroidapp.data.local.Room.Cache.DataScheduleDao
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.omgupsapp.data.local.Room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {


    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            AppDatabase::class.java, "database-name"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideCookieJar(appDatabase: AppDatabase): CookieDao {
        return appDatabase.cookieDao()
    }

    @Singleton
    @Provides
    fun provideDataSchedule(appDatabase: AppDatabase): DataScheduleDao {
        return appDatabase.dataScheduleDao()
    }

   /* @Singleton
    @Provides
    suspend fun fetchData(url: String, @Named("AppData") appDatabase: AppDatabase, @Named("gson") retrofit: Retrofit): String {
        val cachedData = appDatabase.dataCacheDao().getCache(url)
        if (cachedData != null && System.currentTimeMillis() - cachedData.timestamp < 1000) {
            return cachedData.json
        } else {
            val responseBody = retrofit.create(Retrofit::class.java).getData(url).body()
            appDatabase.dataCacheDao().insertCache(DataCache(url, responseBody, System.currentTimeMillis()))
            return responseBody.getData(url).body()
        }
     }*/
}