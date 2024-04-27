package com.omgupsapp.data.local.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieEntity

@Database(entities = [CookieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cookieDao(): CookieDao

}