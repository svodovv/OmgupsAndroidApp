package com.example.omgupsandroidapp.presentation.ui.LoginScreen

data class AuthenticationState(
    val userAuthenticated: Boolean? = null,
    val error: String = "",
    val isLoading: Boolean = false,
    val login: String = "Козлова Ольга Николаевна",
    val password: String = "0",
)