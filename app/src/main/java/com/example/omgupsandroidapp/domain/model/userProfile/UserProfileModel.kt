package com.example.omgupsandroidapp.domain.model.userProfile

import androidx.compose.ui.graphics.vector.ImageVector

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
