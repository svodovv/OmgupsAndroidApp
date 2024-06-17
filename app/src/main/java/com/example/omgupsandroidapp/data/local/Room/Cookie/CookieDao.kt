package com.example.omgupsandroidapp.data.local.Room.Cookie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CookieDao {
    @Insert
    suspend fun insertCookie(cookie: CookieEntity)

    @Query("DELETE FROM cookies ")
    suspend fun deleteCookie()

    @Query("SELECT * FROM cookies WHERE host = :host")
    fun getCookiesForHost(host: String): List<CookieEntity>

    @Query("DELETE FROM cookies")
    suspend fun deleteAllCookies()


}