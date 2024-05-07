package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.UserProfileDto.UserProfileDto

interface UserProfileApi {
    suspend fun getUserProfile(): UserProfileDto
}