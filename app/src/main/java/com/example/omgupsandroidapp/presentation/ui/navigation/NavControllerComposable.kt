package com.omgupsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.ScholarshipScreen.ScholarshipScreen
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.OrderScreen.OrderScreen
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.PlanScreen.PlanScreen
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.SpravkaScreen.SpravkaScreen
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.StudentBookScreen.StudentBookScreen
import com.example.omgupsandroidapp.presentation.ui.screens.SplashScreen.SplashScreen
import com.omgupsapp.presentation.NavigationGroup
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.LoginScreen.components.AuthScreen
import com.omgupsapp.presentation.ui.SheduleScreen.ScheduleScreen
import com.omgupsapp.presentation.ui.homeScreen.components.ServiceScreen
import com.omgupsapp.presentation.ui.userProfileScreen.composable.UserProfileScreen


@Composable
fun NavHostComposable(
    navController: NavHostController, paddingValues: PaddingValues
) {


    NavHost(
        navController = navController,
        startDestination = NavigationGroup.AuthGroup.route
    ) {



        navigation(
            startDestination = Screen.SplashScreen.route,
            route = NavigationGroup.AuthGroup.route

        ) {

            composable(route = Screen.SplashScreen.route) {
                SplashScreen(navController = navController)
            }

            composable(route = Screen.AuthScreen.route) {
                AuthScreen(navController = navController)
            }/*
                Если появятся такие страницы как забыли пароль или регистрация, все должно быть тут
             */
        }
        navigation(
            startDestination = Screen.UserProfileScreen.route,
            route = NavigationGroup.HomeScreens.route
        ) {


            composable(route = Screen.UserProfileScreen.route) {
                UserProfileScreen(
                    navController = navController, paddingValues = paddingValues
                )
            }

            composable(route = Screen.Service.route) {
                ServiceScreen(
                    navController = navController, paddingValues = paddingValues
                )

            }
            composable(Screen.ScholarshipScreen.route) {
                ScholarshipScreen(navController = navController, paddingValues = paddingValues)
            }
            composable(Screen.OrderScreen.route) {
                OrderScreen(navController = navController, paddingValues = paddingValues)
            }

            composable(Screen.PlanScreen.route) {
                PlanScreen(navController = navController, paddingValues = paddingValues)
            }

            composable(Screen.StudentBookScreen.route) {
                StudentBookScreen(navController = navController, paddingValues = paddingValues)
            }
            composable(Screen.SpravkaScreen.route) {
                SpravkaScreen(navController = navController, paddingValues = paddingValues)
            }
            composable(route = Screen.ScheduleScreen.route) {
                ScheduleScreen(
                    navController = navController, paddingValues = paddingValues
                )
            }
        }
    }
}