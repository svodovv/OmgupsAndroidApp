package com.example.omgupsandroidapp.domain.repository

import com.example.omgupsandroidapp.data.remote.dto.user.UserProfileDto

interface UserProfileRepository {

    suspend fun getUserProfile(): UserProfileDto?
}