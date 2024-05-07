package com.example.omgupsandroidapp.data.local.Room.UserData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserData")
data class UserDataEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userName : String,
    val encryptPassword: String
)