package com.example.omgupsandroidapp.presentation.ui.screens.LoginScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.omgupsandroidapp.R

@Composable
fun OmgupsIcon(modifier: Modifier = Modifier) {
    /*Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onSecondary)
    ) {*/
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = R.drawable.omgups_icon_150),
                contentDescription = stringResource(
                    id = R.string.omgupslogo
                ),
                modifier = Modifier,
                tint = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    //}
}
@Composable
fun OmgupsIconFon() {
    Row {
        Box(modifier = Modifier.fillMaxSize().weight(4f), contentAlignment = Center) {
            OmgupsIcon(
                modifier = Modifier.padding(vertical = 100.dp, horizontal = 130.dp),
            )
        }
    }
}

