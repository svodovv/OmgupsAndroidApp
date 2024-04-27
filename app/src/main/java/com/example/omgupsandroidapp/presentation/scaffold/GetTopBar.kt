package com.omgupsapp.presentation.scaffold

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.omgupsapp.presentation.Screen

@Composable
fun GetTopBar(
    navController: NavController,
    route: String,
    selectedTitle: String
) {
    if (route == Screen.AuthScreen.route
        || route == Screen.LogOutScreen.route) {
        /* Пустой @Composable */
    } else {
        TopAppBarComposable(
            navController = navController,
            selectedTitle = selectedTitle
            )
    }
}