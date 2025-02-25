package com.example.omgupsandroidapp.data.remote.dto.authDto

data class AuthFields(
    val identity : String,
    val password : String,
    val rememberMe : String

)

data class AuthResponse(
    val status: String
)