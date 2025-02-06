package com.example.omgupsandroidapp.presentation.ui.LoginScreen

data class AuthenticationState(
    val userAuthenticated: Boolean? = null,
    val error: String = "",
    val isLoading: Boolean = false,
    val login: String = "Вечный студент"/*"Tokitoshike@gmail.com" 6cgdrAzg/*" Синеко Егор Вадимович Муромцева Ангелина Викторовна Вечный Студент"*/,*/,
    val password: String = "8",
)
