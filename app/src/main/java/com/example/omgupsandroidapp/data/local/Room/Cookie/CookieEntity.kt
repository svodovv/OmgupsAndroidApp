package com.example.omgupsandroidapp.data.local.Room.Cookie

import androidx.room.Entity
import androidx.room.PrimaryKey
import okhttp3.Cookie

@Entity(tableName = "cookies")
data class CookieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val host: String,
    val name: String,
    val value: String,
    val expiresAt: Long,
)
