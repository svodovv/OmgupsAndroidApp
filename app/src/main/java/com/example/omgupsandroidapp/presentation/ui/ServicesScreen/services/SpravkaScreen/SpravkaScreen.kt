package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import kotlinx.coroutines.launch


@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpravkaScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    spravkiViewModel: SpravkiViewModel = hiltViewModel(),
    referenceHistoryViewModel : ReferenceHistoryViewModel = hiltViewModel(),
    spravkaViewModul: StatusSpravkaViewModul = hiltViewModel(),
    orderSpravkaViewModel: OrderSpravkaViewModel = hiltViewModel()
) {


    var InputSpravka0 by remember { mutableStateOf("") }
    var InputSpravka1 by remember { mutableStateOf("") }
    val spravki = spravkiViewModel.spravkiState.collectAsStateWithLifecycle()
    val referenceHistory = referenceHistoryViewModel.referenceHistoryState.collectAsStateWithLifecycle()
    val spravka = orderSpravkaViewModel.orderSpravka.collectAsStateWithLifecycle()
    val statysSpravki = spravkaViewModul.status.collectAsStateWithLifecycle()
    val types = spravkiViewModel.spravkiState.value
    val listStatusSpravka = listOf("Нет:Заявка не найдена","Да:На подписании","Да:В работе","Да:Создано","Да:Готово",)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = ScrollState(0),
                enabled = true

            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ServicesTopAppBar(title = "Заказать справку", navController = navController)
        Card (
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxSize(1f)
               // .weight(0.2f)
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
                            value = InputSpravka0,
                            onValueChange = { InputSpravka0 = it },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            maxLines = 1,
                            label = { Text(
                                stringResource(R.string.current_spravok),
                                fontSize = 12.sp,
                                color = Color.White,
                            ) },
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(.4f),
                            onClick = {
                                    orderSpravkaViewModel.postSravka(
                                        LoadSpravka(
                                            types.spravkiList[0].ID,
                                            InputSpravka0
                                        )
                                    )
                            }
                        ) {
                            Text(text = "Заказать")
                        }
                    }
                    var ind : Int = 0
                    Spacer(modifier = Modifier.size(20.dp, 20.dp))
                    spravkaViewModul.viewModelScope.launch {
                        spravkaViewModul.getStatus(0)
                        val stasus = spravkaViewModul.status.value.spravkiStatus
                        listStatusSpravka.mapIndexed { index, result ->
                            when (result) {
                                stasus -> ind = index
                            }
                        }.withIndex()
                    }
                    OrderStatusBar(ind)
                }
            }
        }
        Card (
            modifier = Modifier
                .padding(10.dp, 10.dp)
                //.weight(0.2f)
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
                            value = InputSpravka1,
                            onValueChange = { InputSpravka1 = it },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            maxLines = 1,
                            label = { Text(
                                stringResource(R.string.current_spravok),
                                fontSize = 12.sp,
                                color = Color.White,
                            ) },
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(.4f),
                            onClick = {
                                    orderSpravkaViewModel.postSravka(
                                        LoadSpravka(
                                            types.spravkiList[1].ID,
                                            InputSpravka1
                                        )
                                    )

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
        val stages = listOf("Заказано", "В работе", "На подписании", "Готова")

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp)
        ) {
            stages.forEachIndexed { index, stage ->

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stage,
                        color = Color.Black,
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
                            )
                    )

                }
            }
        }
    }

