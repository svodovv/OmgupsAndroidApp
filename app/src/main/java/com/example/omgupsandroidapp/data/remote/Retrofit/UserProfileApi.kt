package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.user.UserProfileDto

interface UserProfileApi {
    suspend fun getUserProfile(): UserProfileDto
}