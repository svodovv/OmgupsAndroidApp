package com.omgupsapp.presentation.ui.SettingsScreen

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.omgupsapp.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    logOutViewModel: SettingsViewModel = hiltViewModel()
) {

    TopAppBar(title = {
        Box(modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.Settings),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.fillMaxWidth()
        )
    },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "arrow back"
            )
        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Text(text = "HOME SCREEN")
            Button(onClick = {
                logOutViewModel.logout()
                navController.navigate(Screen.AuthScreen.route)
            }) {
                Text(text = "Выход")
            }
        }
    }
}




