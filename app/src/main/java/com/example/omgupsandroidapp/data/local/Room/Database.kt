package com.omgupsapp.data.local.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omgupsapp.data.local.Room.Dao.CookieDao
import com.omgupsapp.data.local.Room.Model.CookieEntity

@Database(entities = [CookieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cookieDao(): CookieDao

}