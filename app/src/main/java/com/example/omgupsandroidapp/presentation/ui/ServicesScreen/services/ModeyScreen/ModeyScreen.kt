package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ModeyScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar

@Composable
fun MoneyScreen(
    navController: NavController, paddingValues: PaddingValues
) {
    ServicesTopAppBar(title = "Выплаты", navController = navController)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MODENY SCREEN")
    }
}