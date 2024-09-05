package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.user.UserInfoDto
import retrofit2.http.GET

interface UserInfoApi {

    @GET("studentInfo/info/get-info")
    suspend fun getUserInfo(): UserInfoDto

    @GET("studentInfo/info/get-photo")
    suspend fun getPhoto(): String
}