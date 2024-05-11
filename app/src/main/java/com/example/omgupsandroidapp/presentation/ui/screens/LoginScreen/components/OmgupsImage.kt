package com.example.omgupsandroidapp.presentation.ui.screens.LoginScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.omgupsandroidapp.R

@Composable
fun OmgupsImage (modifier: Modifier = Modifier){
    Box(
        modifier = modifier
    ) {
        Image(
            painterResource(id =
            if (isSystemInDarkTheme()) {
                R.drawable.omgups_logo_dark
            }else{
                R.drawable.omgups_logo_ligth
            })
                ,
            contentDescription = stringResource(R.string.omgupslogo),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}