package com.example.omgupsandroidapp.presentation.ui.screens.UserProfileScreen

import com.example.omgupsandroidapp.domain.model.userProfile.UserProfileModel

data class UserProfileState(
    val userProfile: UserProfileModel? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)