package com.omgupsapp.presentation

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.omgupsandroidapp.R
import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.presentation.navigation.NavHostComposable
import com.omgupsapp.presentation.scaffold.ScaffoldComposable


data class BottomNavigationItem(
    val tittle: String, // Что будет написано в title
    val route: String, // Путь до страницы
    @DrawableRes val selectedIcon: Int,// Выбранный значёк
    val hasNews: Boolean, //Есть ли уведомление
    val badeCount: Int? = null // Колличество уведомлений на странице
)

@Composable
fun App(dataStoreManager: DataStoreManager, navController: NavHostController) {

    val itemsBottomBar = listOf(
        BottomNavigationItem(
            tittle = "Сервисы",
            route = Screen.HomeScreen.route,
            selectedIcon = R.drawable.ic_services,
            hasNews = false,
        ),
        BottomNavigationItem(
            tittle = "Профиль",
            route = Screen.UserProfileScreen.route,
            selectedIcon = R.drawable.ic_outilineprofile,
            hasNews = false,
        ),
        BottomNavigationItem(
            tittle = "Расписание",
            route = Screen.ScheduleScreen.route,
            selectedIcon = R.drawable.ic_outline_schedule,
            hasNews = false,
        ),
    )

    ScaffoldComposable(
        navController = navController,
        itemsBottomBar = itemsBottomBar,
    ) {
        NavHostComposable(
            navController = navController, paddingValues = it
        )
    }

}
