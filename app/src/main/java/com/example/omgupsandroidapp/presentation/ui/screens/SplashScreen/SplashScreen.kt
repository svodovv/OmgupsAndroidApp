package com.example.omgupsandroidapp.presentation.ui.screens.SplashScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.screens.LoadingScreen.LoadingScreen
import com.omgupsapp.presentation.NavigationGroup
import com.omgupsapp.presentation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel()
) {

    val splashScreenState = splashScreenViewModel.splashScreenState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = splashScreenState.value.isUserSignIn) {
        delay(1000)
        splashScreenState.value.isUserSignIn?.let {
            if (it) {
                navController.navigate(NavigationGroup.HomeScreens.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            } else navController.navigate(Screen.AuthScreen.route) {
                popUpTo(Screen.SplashScreen.route) {
                    inclusive = true
                }
            }
        }
    }

    LoadingScreen()
}