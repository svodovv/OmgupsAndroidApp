package com.example.omgupsandroidapp.presentation.ui.SettingsScreen.copmposable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.omgupsapp.presentation.Screen
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
    ) {
        SettingsTopAppBar(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Divider(
                color = Color.Red,
                thickness = 0.5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Text(
                text = stringResource(R.string.exit),
                color = Color.Red,
                modifier = Modifier.clickable {
                    logOutViewModel.logout()
                    navController.navigate(Screen.SplashScreen.route)
                },
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}




