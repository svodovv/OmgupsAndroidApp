package com.omgupsapp.di

import android.content.Context
import androidx.room.Room
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.omgupsapp.data.local.Room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
        ).build()
    }

    @Singleton
    @Provides
    fun provideCookieJar(appDatabase: AppDatabase): CookieDao{
        return appDatabase.cookieDao()
    }
}