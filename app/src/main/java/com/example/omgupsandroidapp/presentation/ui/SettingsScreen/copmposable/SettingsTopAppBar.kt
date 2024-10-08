package com.example.omgupsandroidapp.presentation.ui.SettingsScreen.copmposable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTopAppBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    TopAppBar(title = {
        Text(
            text = stringResource(R.string.Settings),
            color = MaterialTheme.colorScheme.surfaceVariant,
            style = MaterialTheme.typography.displayMedium
        )
    },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "arrow back"
                )
            }
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.onSecondary)
    )
}