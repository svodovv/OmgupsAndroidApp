package com.example.omgupsandroidapp.presentation.ui.userProfileScreen

import com.example.omgupsandroidapp.domain.model.user.UserInfoModel
import com.example.omgupsandroidapp.domain.model.user.UserPhotoUrlModel

data class UserProfileState(
    val userProfile: UserInfoModel? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)

data class UserPhotoState(
    val userPhoto: UserPhotoUrlModel = UserPhotoUrlModel("",200),
    val isLoading: Boolean = false,
    val error: String = ""
)