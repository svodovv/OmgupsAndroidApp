package com.example.omgupsandroidapp.presentation.ui.LoginScreen

data class AuthenticationState(
    val userAuthenticated: Boolean? = null,
    val error: String = "",
    val isLoading: Boolean = false,
    val login: String = ""/*"Tokitoshike@gmail.com" 6cgdrAzg/*" Синеко Егор Вадимович Муромцева Ангелина Викторовна Вечный Студент"*/,*/,
    val password: String = "",
)
