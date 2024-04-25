package com.omgupsapp.data.local.Room.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import okhttp3.Cookie

@Entity(tableName = "cookies")
data class CookieEntity(
    @PrimaryKey
    val cookieString: String,
)
