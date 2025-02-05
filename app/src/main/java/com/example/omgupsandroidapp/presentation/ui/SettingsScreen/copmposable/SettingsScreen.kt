package com.example.omgupsandroidapp.presentation.ui.SettingsScreen.copmposable

import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
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
            Row (
                horizontalArrangement = Arrangement.SpaceAround
            ) {
              //  if (logOutState.value) {
                    /*LogoutAlertDialog(
                        onDismissRequest = {
                            logOutState.value = false // Закрыть диалог
                        }, navController = navController
                    )*/
              //  }
                TextButton(onClick = {openDialog.value = true}) {
                    Text(
                        text = stringResource(R.string.exit),
                        color = Color.Red,
                        style = MaterialTheme.typography.displayMedium
                    )
                }
                ChangeIconApp()
                if (openDialog.value){
                    Dialog(
                        onDismissRequest = { openDialog.value = false }
                    ) {
                        Surface(
                            shape = MaterialTheme.shapes.large,
                            tonalElevation = AlertDialogDefaults.TonalElevation,
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = CenterHorizontally
                            ) {
                                // Иконка
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_alert_dialog),
                                    contentDescription = "logOut alert dialog",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.align(CenterHorizontally)
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                // Заголовок
                                Text(
                                    text = "Подтвердите выход",
                                    style = MaterialTheme.typography.headlineSmall,
                                    modifier = Modifier.align(CenterHorizontally)
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                // Текст сообщения
                                Text(
                                    text = "Вы действительно хотите выйти?",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.align(CenterHorizontally)
                                )

                                Spacer(modifier = Modifier.height(24.dp))

                                // Ряд с кнопками
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 4.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    // Кнопка "Отменить" справа
                                    TextButton(
                                        onClick = { openDialog.value = false }
                                    ) {
                                        Text("Отменить")
                                    }

                                    TextButton(
                                        onClick = {
                                            logOutViewModel.logOut()
                                            navController.navigate(Screen.SplashScreen.route) {
                                                popUpTo(0) { inclusive = true }
                                            }
                                        }
                                    ) {
                                        Text("Подтвердить")
                                    }
                                }
                            }
                        }
                    }
                    /*AlertDialog(icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_alert_dialog),
                            contentDescription = "logOut alert dialog",
                            tint = MaterialTheme.colorScheme.primary
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
                        })*/
                }
            }
        }
    }
}


@Composable
fun ChangeIconApp() {
    val context = LocalContext.current
    var currentIcon by remember { mutableStateOf(1) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            Column {
                Box{
                    R.drawable.ic_launcher_foreground_classik
                }
            }
            Column {
                Box{

                }
            }
        }
        Button(onClick = {
            changeIcon(context, if (currentIcon == 1) 2 else 1)
            currentIcon = if (currentIcon == 1) 2 else 1
        }) {
            Text("Сменить иконку")
        }
    }
}

private fun changeIcon(context: android.content.Context, iconNumber: Int) {
    val packageManager = context.packageManager

    // Отключаем текущий activity-alias
    packageManager.setComponentEnabledSetting(
        ComponentName(context, "com.example.yourapp.MainActivityAlias$iconNumber"),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP
    )

    // Включаем новый activity-alias
    packageManager.setComponentEnabledSetting(
        ComponentName(context, "com.example.yourapp.MainActivityAlias$iconNumber"),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )
}



