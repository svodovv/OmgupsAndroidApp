package com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesTopAppBar(title: String, navController: NavController) {
    TopAppBar(title = {
        Text(text = title, style = MaterialTheme.typography.displayMedium)
    }, navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "arrow back in $title"
            )
        }
    })
}