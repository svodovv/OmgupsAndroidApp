package com.example.omgupsandroidapp.domain.repository

import com.example.omgupsandroidapp.data.remote.dto.user.UserProfileDto
import com.example.omgupsandroidapp.domain.model.user.UserInfoModel

interface UserProfileRepository {

    suspend fun getUserInfo(): UserInfoModel
}