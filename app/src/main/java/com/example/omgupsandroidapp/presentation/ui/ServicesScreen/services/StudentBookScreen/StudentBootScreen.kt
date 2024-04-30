package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.StudentBookScreen

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
import com.omgupsapp.presentation.Screen

@Composable
fun StudentBookScreen(
    navController: NavController, paddingValues: PaddingValues
) {
    ServicesTopAppBar(title = "Зачетная книжка", navController = navController)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "STUDENT BOOK SCREEN")
    }
}