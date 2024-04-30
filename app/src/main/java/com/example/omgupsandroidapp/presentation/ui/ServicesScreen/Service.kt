package com.example.omgupsandroidapp.presentation.ui.ServicesScreen

import androidx.annotation.DrawableRes

data class Service(
    val serviceName: String,
    val route: String,
    @DrawableRes val selectedIcon: Int,
)
