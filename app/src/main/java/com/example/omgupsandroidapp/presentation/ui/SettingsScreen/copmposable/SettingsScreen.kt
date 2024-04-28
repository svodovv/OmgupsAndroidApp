package com.example.omgupsandroidapp.presentation.ui.SettingsScreen.copmposable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.omgupsapp.presentation.ui.SettingsScreen.SettingsViewModel

@Composable
fun SettingsScreen(
    navController: NavController,
    logOutViewModel: SettingsViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val themeState = logOutViewModel.themeState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        SettingsTopAppBar(
            navController = navController, modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
        )
        ThemeSwitcher(
            darkTheme = themeState.value.themeState,
            size = 100.dp,
            padding = 5.dp,
            onClick = { logOutViewModel.themeUpdate(themeState.value.themeState) }
        )
    }
}




