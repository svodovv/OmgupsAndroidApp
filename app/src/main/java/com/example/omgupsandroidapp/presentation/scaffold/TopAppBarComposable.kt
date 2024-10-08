package com.omgupsapp.presentation.scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.omgupsapp.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable(
    navController: NavController,
    selectedTitle: String,
    //logOutClick: () -> Unit
    ) {
    TopAppBar(
        title = {
            Text(
                text = selectedTitle,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.surfaceVariant
            )
        },
        actions = {
            IconButton(onClick = {
                //logOutClick()
                navController.navigate(Screen.SettingsScreen.route)
            }) {
                Icon(
                    painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Settings icon",
                    tint = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.onSecondary)
    )
}

