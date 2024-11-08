package com.example.omgupsandroidapp.data.local.Room.Cache

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "data_cache")
data class DataCache(
    @PrimaryKey val url: String,
    val json: String,
    val timestamp: Long )

