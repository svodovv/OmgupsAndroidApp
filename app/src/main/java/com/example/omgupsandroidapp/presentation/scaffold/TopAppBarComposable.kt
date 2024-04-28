package com.omgupsapp.presentation.scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.omgupsapp.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable(
    navController: NavController,
    selectedTitle: String
    ) {
    TopAppBar(
        title = {
            Text(
                text = selectedTitle,
                style = MaterialTheme.typography.displayMedium
            )
        },
        actions = {
            IconButton(onClick = { navController.navigate(Screen.LogOutScreen.route) }) {
                Icon(
                    painterResource(id = R.drawable.round_settings_30),
                    contentDescription = "Settings icon"
                )
            }
        }
    )
}

