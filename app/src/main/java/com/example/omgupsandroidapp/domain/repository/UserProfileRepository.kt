package com.example.omgupsandroidapp.domain.repository

import com.example.omgupsandroidapp.data.remote.dto.UserProfileDto.UserProfileDto

interface UserProfileRepository {

    suspend fun getUserProfile(): UserProfileDto?
}
