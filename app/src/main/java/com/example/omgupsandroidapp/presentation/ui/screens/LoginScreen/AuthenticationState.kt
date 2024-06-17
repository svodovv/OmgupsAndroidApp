package com.example.omgupsandroidapp.presentation.ui.screens.LoginScreen

data class AuthenticationState(
    val userAuthenticated: Boolean? = null,
    val error: String = "",
    val isLoading: Boolean = false,
    val login: String = "Кондратьев Владимир Андреевич",
    val password: String = "2",
)