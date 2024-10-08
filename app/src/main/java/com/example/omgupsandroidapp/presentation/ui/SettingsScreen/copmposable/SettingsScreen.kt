package com.example.omgupsandroidapp.presentation.ui.SettingsScreen.copmposable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.presentation.ui.screens.LogoutScreen.LogoutAlertDialog
import com.omgupsapp.presentation.NavigationGroup
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.SettingsScreen.SettingsViewModel

@Composable
fun SettingsScreen(
    navController: NavController,
    logOutViewModel: SettingsViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val themeState = logOutViewModel.themeState.collectAsStateWithLifecycle()

    var openDialog = remember {
        mutableStateOf(false)
    }

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
            Row {
              //  if (logOutState.value) {
                    /*LogoutAlertDialog(
                        onDismissRequest = {
                            logOutState.value = false // Закрыть диалог
                        }, navController = navController
                    )*/
              //  }
                Text(
                    text = stringResource(R.string.exit),
                    color = Color.Black,
                    modifier = Modifier.clickable {
                        openDialog.value = true
                       // logOutViewModel.logout()
                        /*navController.navigate(Screen.SplashScreen.route) {
                            popUpTo(0) {
                                inclusive = true
                            }
                        }*/
                    },
                    style = MaterialTheme.typography.displayMedium
                )
                if (openDialog.value){
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
            }
        }
    }
}




