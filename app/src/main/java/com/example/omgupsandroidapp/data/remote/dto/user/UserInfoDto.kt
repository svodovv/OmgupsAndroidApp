package com.example.omgupsandroidapp.data.remote.dto.user

import com.example.omgupsandroidapp.domain.model.user.UserInfoModel
import com.example.omgupsandroidapp.domain.model.user.UserProfileModel
import com.google.gson.annotations.SerializedName

data class UserInfoDto(

    @SerializedName("Course")
    val course: Int,
    @SerializedName("Faculty")
    val faculty: String,
    @SerializedName("FormEducation")
    val formEducation: String,
    @SerializedName("Group")
    val group: String,
    @SerializedName("OrderNumber")
    val orderNumber: String,
    @SerializedName("RecordBook")
    val recordBook: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Username")
    val username: String
)

fun UserInfoDto.toUserInfoModel(photoUrl: String): UserInfoModel {
    return UserInfoModel(
        photoUrl = photoUrl,
        course = course,
        faculty = faculty,
        formEducation = formEducation,
        group = group,
        orderNumber = orderNumber,
        recordBook = recordBook,
        status = status,
        username = username
    )
}
