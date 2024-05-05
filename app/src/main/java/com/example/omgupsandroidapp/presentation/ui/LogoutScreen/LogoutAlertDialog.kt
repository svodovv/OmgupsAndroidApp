package com.example.omgupsandroidapp.presentation.ui.LogoutScreen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.omgupsandroidapp.R

@Composable
fun LogoutAlertDialog(
    onDismissRequest: () -> Unit,
    logOutViewModel: LogOutViewModel = hiltViewModel(),
) {

    AlertDialog(
        icon = {
            Icon(painter = painterResource(id = R.drawable.round_person_30), contentDescription = "logOut alert dialog")
        },
        onDismissRequest = { onDismissRequest() },
        title = { Text(text = "Подтвердите выход") },
        text = { Text("Вы действительно хотите выйти?") },
        confirmButton = {
            TextButton(onClick = {
                onDismissRequest()
                logOutViewModel.logOut() }) {
                Text(text = "Подтвердить")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text(text = "Отменить")
            }
        }
    )

}