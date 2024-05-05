package com.omgupsapp.presentation.scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.presentation.ui.LogoutScreen.LogoutAlertDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable(
    navController: NavController,
    selectedTitle: String
) {
    val logOutState = remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = {
            Text(
                text = selectedTitle,
                style = MaterialTheme.typography.displayMedium
            )
        },
        actions = {
            IconButton(onClick = {
                logOutState.value = true
            }) {
                Icon(
                    painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Settings icon"
                )
            }
        }
    )
    if (logOutState.value) {
        LogoutAlertDialog(onDismissRequest = { logOutState.value })
    }
}

