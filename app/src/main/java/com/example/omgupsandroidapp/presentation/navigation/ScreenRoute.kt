package com.omgupsapp.presentation

sealed class Screen(val route: String) {
    //Auth Group
    data object AuthScreen : Screen("auth_screen")

    //HomeScreensGroup
    data object LogOutScreen : Screen("logOut_screen")
    data object UserProfileScreen : Screen("user_profile_screen")
    data object HomeScreen : Screen("home_screen")
    data object ScheduleScreen : Screen("schedule_screen")

    data object SplashScreen: Screen("splash_screen")
}

sealed class NavigationGroup(val route: String) {
    data object AuthGroup : NavigationGroup("auth_screens")

    data object HomeScreens : NavigationGroup("home_screens")

}