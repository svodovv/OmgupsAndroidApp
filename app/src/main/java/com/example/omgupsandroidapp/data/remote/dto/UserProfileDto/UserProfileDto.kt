package com.example.omgupsandroidapp.data.remote.dto.UserProfileDto

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.omgupsandroidapp.domain.model.userProfile.UserProfileModel

data class UserProfileDto(
    val imageVector: ImageVector?,
    val name: String,
    val surname: String,
    val patronymic: String,
    val institute: String,
    val specialization: String,
    val direction: String,
    val group: String,
    val formEducation: String,
    val typeEducation: String,
    val statusEducation: String,
    val lvlEducation: String,
    val course: Int,
)

fun UserProfileDto.toUserProfileModel(): UserProfileModel {
    return UserProfileModel(
        imageVector = imageVector,
        name = name,
        surname = surname,
        patronymic = patronymic,
        institute = institute,
        specialization = specialization,
        direction = direction,
        group = group,
        formEducation = formEducation,
        typeEducation = typeEducation,
        statusEducation = statusEducation,
        lvlEducation = lvlEducation,
        course = course,
    )
}
