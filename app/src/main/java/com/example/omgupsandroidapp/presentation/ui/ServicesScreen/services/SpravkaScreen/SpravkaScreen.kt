package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import com.omgupsapp.presentation.Screen

@SuppressLint("UnrememberedMutableState")
@Composable
fun SpravkaScreen(
    navController: NavController, paddingValues: PaddingValues
) {
    ServicesTopAppBar(title = "Заказать справку", navController = navController)


   /* Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       // SampleSpravka(R.string.Spravka_military)
        SampleSpravka(namdeSpravka = R.string.Spravka_training)
    }*/
    var InputSpravka  by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card (
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFBAEAFF))
                    .fillMaxSize()
            )
            {
                Column (modifier = Modifier.fillMaxWidth()){
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            fontSize = 22.sp,
                            color = Color.Black,
                            text = "Справка об обучении"
                        )
                    }
                    Spacer(modifier = Modifier.size(20.dp, 20.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                         verticalAlignment = Alignment.CenterVertically,
                         horizontalArrangement = Arrangement.Absolute.SpaceAround
                    ) {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(.2f)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            value = InputSpravka,
                            onValueChange = { InputSpravka = it },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            maxLines = 1,
                            label = { Text(
                                stringResource(R.string.current_spravok),
                                fontSize = 12.sp,
                                color = Color.Black,
                            ) },
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(.4f),
                            onClick = {
                                // Отправка значения InputSpravka на сервер
                            }
                        ) {
                            Text(text = "Заказать")
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp, 20.dp))

                    OrderStatusBar(0)

                }
            }
        }
        Card (
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFBAEAFF))
                    .fillMaxSize()
            )
            {
                Column (modifier = Modifier.fillMaxWidth()){
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            fontSize = 22.sp,
                            color = Color.Black,
                            text = stringResource(id = R.string.Spravka_military)
                        )
                    }
                    Spacer(modifier = Modifier.size(20.dp, 20.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Absolute.SpaceAround
                    ) {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(.2f)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            value = InputSpravka,
                            onValueChange = { InputSpravka = it },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            maxLines = 1,
                            label = { Text(
                                stringResource(R.string.current_spravok),
                                fontSize = 12.sp,
                                color = Color.Black,
                            ) },
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(.4f),
                            onClick = {
                                // Отправка значения InputSpravka на сервер
                            }
                        ) {
                            Text(text = "Заказать")
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp, 20.dp))

                    OrderStatusBar(0)

                }
            }
        }
    }
    
}


/*@Composable
fun SampleSpravka(
    namdeSpravka : Int
){
    var InputSpravka  by remember { mutableStateOf("") }
    /*Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {*/
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Absolute.Center

    ) {
        Card(
            modifier = Modifier
                .padding(10.dp, 60.dp)
                .weight(2f)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFBAEAFF))
                    .fillMaxSize()
            )
            {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            fontSize = 22.sp,
                            color = Color.Black,
                            text = stringResource(namdeSpravka)
                        )
                    }
                    Spacer(modifier = Modifier.size(20.dp, 20.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Absolute.SpaceAround
                    ) {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(.2f)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            value = InputSpravka,
                            onValueChange = { InputSpravka = it },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            maxLines = 1,
                            label = {
                                Text(
                                    stringResource(R.string.current_spravok),
                                    fontSize = 12.sp,
                                    color = Color.Black,
                                )
                            },
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(.4f),
                            onClick = {
                                // Отправка значения InputSpravka на сервер
                            }
                        ) {
                            Text(text = "Заказать")
                        }
                    }
                    Spacer(modifier = Modifier.size(20.dp, 20.dp))

                    OrderStatusBar(0)

                }
            }
        }
        Spacer(modifier = Modifier.size(200.dp))
        // }
    }
}*/
@Composable
fun OrderStatusBar(currentStage: Int) {
    val stages = listOf("Заказано", "В работе", "Готова")

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        stages.forEachIndexed { index, stage ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    Text(
                        text = stage,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                Spacer(modifier = Modifier.size(10.dp, 10.dp))
                    Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            if (index <= currentStage) Color.Green else Color.Gray,
                            shape = CircleShape
                        ))

            }
        }
    }
}
