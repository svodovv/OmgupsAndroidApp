package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.user.UserInfoDto
import com.example.omgupsandroidapp.data.remote.dto.user.UserPhotoDto
import com.example.omgupsandroidapp.domain.model.user.UserPhotoUrlModel
import retrofit2.http.GET

interface UserInfoApi {

    @GET("studentInfo/info/get-info")
    suspend fun getUserInfo(): UserInfoDto

    @GET("student-info/get-photo")
    suspend fun getPhoto(): UserPhotoDto
}