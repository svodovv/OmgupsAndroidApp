package com.example.omgupsandroidapp.presentation.ui.userProfileScreen

import com.example.omgupsandroidapp.domain.model.user.UserInfoModel

data class UserProfileState(
    val userProfile: UserInfoModel? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)