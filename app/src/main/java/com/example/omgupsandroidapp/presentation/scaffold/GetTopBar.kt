package com.omgupsapp.presentation.scaffold

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.omgupsapp.presentation.Screen

@Composable
fun GetTopBar(
    navController: NavController,
    route: String,
    selectedTitle: String,
    //logOutClick: () -> Unit

) {
    if (route == Screen.UserProfileScreen.route || route == Screen.ScheduleScreen.route || route == Screen.Service.route) {
        TopAppBarComposable(
            navController = navController,
            selectedTitle = selectedTitle,
            //logOutClick = logOutClick
        )
    } else {
            //
    }
}