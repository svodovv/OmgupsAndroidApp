package com.example.omgupsandroidapp.domain.model.user

import androidx.compose.ui.graphics.vector.ImageVector
import com.google.gson.annotations.SerializedName

data class UserProfileModel(
    val imageVector: ImageVector?,
    val name: String,
    val surname: String,
    val patronymic: String,
    val institute: String,
    val  specialization: String,
    val direction: String,
    val group: String,
    val  formEducation: String,
    val  typeEducation: String,
    val statusEducation: String,
    val  lvlEducation: String,
    val course: Int
) {

}

data class UserInfoModel(
    val photoUrl: String,
    val course: Int,
    val faculty: String,
    val formEducation: String,
    val group: String,
    val orderNumber: String,
    val recordBook: String,
    val status: String,
    val username: String
)