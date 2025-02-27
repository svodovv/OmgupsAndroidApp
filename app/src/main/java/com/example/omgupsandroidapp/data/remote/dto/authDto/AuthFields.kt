package com.example.omgupsandroidapp.data.remote.dto.authDto

import com.google.gson.annotations.SerializedName

data class AuthFields(
    @SerializedName("identity")
    val identity : String,
    @SerializedName("password")
    val password : String,
    @SerializedName("rememberMe")
    val rememberMe : Int

)

data class AuthResponse(
    val status: String
)