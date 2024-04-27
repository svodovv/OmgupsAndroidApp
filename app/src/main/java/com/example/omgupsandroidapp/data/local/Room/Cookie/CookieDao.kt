package com.example.omgupsandroidapp.data.local.Room.Cookie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CookieDao {
    @Upsert
    suspend fun insertCookie(cookie: CookieEntity)

    @Query("SELECT * FROM cookies WHERE host = :host")
    fun getCookiesForHost(host: String): List<CookieEntity>

    @Query("DELETE FROM cookies")
    suspend fun deleteAllCookies()

    @Query("DELETE FROM cookies WHERE expiresAt < :currentTime")
    suspend fun deleteExpiredCookies(currentTime: Long)
}