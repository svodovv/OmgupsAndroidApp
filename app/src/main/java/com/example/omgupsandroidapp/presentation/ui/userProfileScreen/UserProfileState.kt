package com.example.omgupsandroidapp.presentation.ui.userProfileScreen

import com.example.omgupsandroidapp.domain.model.user.UserProfileModel

data class UserProfileState(
    val userProfile: UserProfileModel? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)