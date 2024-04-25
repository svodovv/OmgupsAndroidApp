package com.omgupsapp.data.local.Room.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.omgupsapp.data.local.Room.Model.CookieEntity

@Dao
interface CookieDao {
    @Upsert
    fun insertAllCookies(cookieList: List<CookieEntity>)

    @Query("SELECT cookieString FROM cookies")
    fun getAllCookies(): List<String>

    @Query("DELETE FROM cookies")
    fun deleteAllCookies()

    @Transaction
    fun deleteCookiesAndAddCookiesTransaction(cookieList: List<CookieEntity>) {
        deleteAllCookies()
        insertAllCookies(cookieList)
    }

}