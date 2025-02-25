package com.omgupsapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.authDto.AuthFields
import com.example.omgupsandroidapp.data.remote.dto.authDto.AuthResponse
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.SpravkaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface AuthApi {
    /*@GET("/user/sign-in/login")
   // suspend fun getHtmlAuthPage(): Response<String>

    @FormUrlEncoded
    @POST("/user/sign-in/login")*/
    @FormUrlEncoded
    @POST("userapi/v2/login/sign-in")
    suspend fun authentication(
        //@Field("_csrf") csrfToken: String,
        @Field("LoginForm[identity]") login: String,
        @Field("LoginForm[password]") password: String,
        @Field("LoginForm[rememberMe]") rememberMe: String,
    ): Response<String>


    /*@FormUrlEncoded
    @POST("userapi/v2/login/sign-in")
    suspend fun authFieldPost(
        @Body post: AuthFields
    ): Response<String>*/


}