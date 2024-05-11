package com.example.omgupsandroidapp.presentation.ui.screens.LogoutScreen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.omgupsapp.presentation.NavigationGroup

@Composable
fun LogoutAlertDialog(
    onDismissRequest: () -> Unit,
    navController: NavController,
    logOutViewModel: LogOutViewModel = hiltViewModel(),
) {

    AlertDialog(icon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_alert_dialog),
            contentDescription = "logOut alert dialog"
        )
    },
        onDismissRequest = { onDismissRequest() },
        title = { Text(text = "Подтвердите выход") },
        text = { Text("Вы действительно хотите выйти?") },
        confirmButton = {
            TextButton(onClick = {
                onDismissRequest()
                logOutViewModel.logOut()
                navController.navigate(NavigationGroup.AuthGroup.route)
            }) {
                Text(text = "Подтвердить")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text(text = "Отменить")
            }
        })

}