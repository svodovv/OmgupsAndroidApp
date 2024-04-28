package com.omgupsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.presentation.NavigationGroup
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.LoginScreen.components.AuthScreen
import com.example.omgupsandroidapp.presentation.ui.SettingsScreen.copmposable.SettingsScreen
import com.omgupsapp.presentation.ui.SheduleScreen.ScheduleScreen
import com.omgupsapp.presentation.ui.homeScreen.components.HomeScreen
import com.omgupsapp.presentation.ui.userProfileScreen.composable.UserProfileScreen


@Composable
fun NavHostComposable(
    navController: NavHostController,
    dataStoreManager: DataStoreManager,
    paddingValues: PaddingValues
) {

    val isLoggedIn = remember {
        mutableStateOf(false)
    }


    LaunchedEffect(key1 = true) {
        dataStoreManager.getLoggedIn().collect {
            isLoggedIn.value = it
        }
    }

    val startDestination = if (isLoggedIn.value)
        NavigationGroup.HomeScreens.route
    else
        NavigationGroup.AuthGroup.route

    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        navigation(
            startDestination = Screen.AuthScreen.route,
            route = NavigationGroup.AuthGroup.route

        ) {
            composable(route = Screen.AuthScreen.route) {
                AuthScreen(navController = navController)
            }
            /*
                Если появятся такие страницы как забыли пароль или регистрация, все должно быть тут
             */
        }
        navigation(
            startDestination = Screen.ScheduleScreen.route,
            route = NavigationGroup.HomeScreens.route
        ) {
            composable(route = Screen.LogOutScreen.route) {
                SettingsScreen(
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
            composable(route = Screen.ScheduleScreen.route) {
                ScheduleScreen(
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
            composable(route = Screen.UserProfileScreen.route) {
                UserProfileScreen(
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
        }
    }
}