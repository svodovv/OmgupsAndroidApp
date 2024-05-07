package com.example.omgupsandroidapp.data.local.Room.UserData

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface UserDataDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserCredentials(userCredentials: UserDataEntity)

    @Query("SELECT * FROM UserData")
    fun getUserCredentialsByUsername(username: String): Flow<List<UserDataEntity>>

    @Query("DELETE FROM UserData")
    suspend fun deleteUserData()
}
