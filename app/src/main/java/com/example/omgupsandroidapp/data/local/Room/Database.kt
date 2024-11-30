package com.omgupsapp.data.local.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.omgupsandroidapp.data.local.Room.Cache.DataScheduleDao
import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity

import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieEntity
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem

@Database(entities = [CookieEntity::class, ScheduleEntity::class], version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cookieDao(): CookieDao
    abstract fun dataScheduleDao(): DataScheduleDao

}