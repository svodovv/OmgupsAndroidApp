package com.example.omgupsandroidapp.presentation.ui.screens.LogoutScreen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.omgupsapp.presentation.NavigationGroup
import com.omgupsapp.presentation.Screen

@Composable
fun LogoutAlertDialog(
    //onDismissRequest: () -> Unit,
    navController: NavController,
    logOutViewModel: LogOutViewModel = hiltViewModel(),
    openDialogFromSetings : Boolean
) {
    var openDialog = remember {
        mutableStateOf(openDialogFromSetings)
    }

    AlertDialog(icon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_alert_dialog),
            contentDescription = "logOut alert dialog"
        )
    },
    onDismissRequest = {openDialog},
    title = { Text(text = "Подтвердите выход") },
    text = { Text("Вы действительно хотите выйти?") },
    confirmButton = {
        TextButton(onClick = {
            //onDismissRequest()
            logOutViewModel.logOut()
            navController.navigate(Screen.SplashScreen.route){
                popUpTo(0) {
                    inclusive = true
                }
            }
        }) {
            Text(text = "Подтвердить")
        }
    },
    dismissButton = {
        TextButton(onClick = {openDialog.value = false }) {
            Text(text = "Отменить")
        }
    })

}