package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import com.omgupsapp.presentation.Screen

@Composable
fun SpravkaScreen(
    navController: NavController, paddingValues: PaddingValues
) {
    ServicesTopAppBar(title = "Заказать справку", navController = navController)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card (
            modifier = Modifier
                .padding(10.dp, 60.dp)
                .weight(1f)
        ) {
            Box(modifier = Modifier
                .background(color = Color(0xFFBAEAFF))
                .fillMaxSize()
            )
            {
                Row(
                    Modifier.fillMaxHeight(0.3f),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        fontSize = 22.sp,
                        color = Color.Black,
                        text = "Справка об обучении"
                    )
                }
                Spacer(modifier = Modifier.size(5.dp))
               /* Row(
                    Modifier.fillMaxHeight(0.6f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    TextField(
                        value = "",
                        onValueChange = { /* Обработчик изменения значения */ },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.
                        size(50.dp)
                    )
                }*/

            }
        }
        Spacer(modifier = Modifier.size(500.dp))
    }
}