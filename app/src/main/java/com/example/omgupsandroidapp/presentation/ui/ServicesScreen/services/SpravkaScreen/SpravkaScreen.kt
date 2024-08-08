package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
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
    val referenceHistory = referenceHistoryViewModel.referenceHistoryState.collectAsStateWithLifecycle()
    val spravka = orderSpravkaViewModel.orderSpravka.collectAsStateWithLifecycle()
    val statusSpravki = spravkaViewModul.status.collectAsStateWithLifecycle()
    val types = spravkiViewModel.spravkiState.value
    val history = referenceHistoryViewModel.referenceHistoryState.value
    var stasus0 = statusSpravki.value.spravkiStatus0
    var stasus1 = statusSpravki.value.spravkiStatus1
    var historylist1 = referenceHistory.value.referenceHistoryList0
    var historylist2 = referenceHistory.value.referenceHistoryList1
    val spravki = spravkiViewModel.spravkiState.collectAsStateWithLifecycle()
    /*LaunchedEffect(stasus0) {
        val status = spravkaViewModul.getStatus(0)
        stasus0 = status
    }*/
    val listStatusSpravka = listOf(
        "Нет:Заявка уже подана.",
        "Да:Создано",
        "Да:В работе",
        "Да:На подписании",
        "Да:К выдаче",
    )
    var indStatus0: Int = -1
    var indStatus1: Int = -1

    var listhistor = listOf(
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент"),
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент"),
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент"),
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент")
    )

    var stastusAfterOrderSpravka = " "
    if (spravki.value.spravkiList.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ServicesTopAppBar(title = "Заказать справку", navController = navController)
            }
            item {
                Card(
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
                        Column(modifier = Modifier.fillMaxWidth()) {
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
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        ),
                                    value = InputSpravka0,
                                    onValueChange = { InputSpravka0 = it },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                                    singleLine = true,
                                    maxLines = 1,
                                    label = {
                                        Text(
                                            stringResource(R.string.current_spravok),
                                            fontSize = 12.sp,
                                            color = Color.White,
                                        )
                                    },
                                )
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth(.4f),
                                    onClick = {
                                        stastusAfterOrderSpravka = orderSpravkaViewModel.postSravka(
                                            LoadSpravka(
                                                types.spravkiList[1].ID,
                                                InputSpravka0
                                            )
                                        )

                                        spravkaViewModul.viewModelScope.launch {
                                            stasus0 = spravkaViewModul.getStatus(1)
                                        }
                                        for ((i, element) in listStatusSpravka.withIndex()) {
                                            if (element == stasus0) {
                                                indStatus0 = i
                                                break
                                            }
                                        }
                                        Log.i("TAAAAG", stasus0)
                                        Log.i("StastusAfterOrderSpravka", stastusAfterOrderSpravka)
                                    }
                                ) {
                                    Text(text = "Заказать")
                                }
                            }
                            /* spravkaViewModul.viewModelScope.launch {
                            stasus0 = spravkaViewModul.getStatus(0)
                        }*/
                            for ((i, element) in listStatusSpravka.withIndex()) {
                                if (element == stasus0) {
                                    indStatus0 = i
                                    break
                                }
                            }
                            if (indStatus0 != -1) {
                                Log.i("TAAAAG", "Индекс совпадающего элемента: $indStatus0")
                            } else {
                                //      Log.i("TAAAAG",referenceHistory.value.referenceHistoryList[0].Status )
                                Log.i("TAAAAG", stasus0)


                            }
                            Spacer(modifier = Modifier.size(20.dp, 20.dp))
                            OrderStatusBar(indStatus0 - 1)
                        }
                    }
                }
                Card(
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
                        Column(modifier = Modifier.fillMaxWidth()) {
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
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(10.dp)
                                        ),
                                    value = InputSpravka1,
                                    onValueChange = { InputSpravka1 = it },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                                    singleLine = true,
                                    maxLines = 1,
                                    label = {
                                        Text(
                                            stringResource(R.string.current_spravok),
                                            fontSize = 12.sp,
                                            color = Color.White,
                                        )
                                    },
                                )
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth(.4f),
                                    onClick = {
                                        orderSpravkaViewModel.postSravka(
                                            LoadSpravka(
                                                types.spravkiList[0].ID,
                                                InputSpravka1
                                            )
                                        )
                                        spravkaViewModul.viewModelScope.launch {
                                            stasus1 = spravkaViewModul.getStatus(1)
                                        }
                                        for ((i, element) in listStatusSpravka.withIndex()) {
                                            if (element == stasus1) {
                                                indStatus1 = i
                                                break
                                            }
                                        }
                                    }
                                ) {
                                    Text(text = "Заказать")
                                }
                            }
                            for ((i, element) in listStatusSpravka.withIndex()) {
                                if (element == stasus1) {
                                    indStatus1 = i
                                    break
                                }
                            }
                            if (indStatus1 != -1) {
                                Log.i("TAAAAG", "Индекс совпадающего элемента: $indStatus0")
                            } else {
                                //      Log.i("TAAAAG",referenceHistory.value.referenceHistoryList[0].Status )
                                Log.i("TAAAAG", stasus0)


                            }
                            Spacer(modifier = Modifier.size(20.dp, 20.dp))
                            OrderStatusBar(indStatus1 - 1)
                            //  OrderStatusBar(0, st)

                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.size(20.dp, 20.dp))
                //Log.i("TAAAAG",history.referenceHistoryList[0].Date )
                // Log.i("TAAAAG",history.referenceHistoryList[] )
                ExpandableOrderTable(historylist1, "История справок по обучению")
                Spacer(modifier = Modifier.size(20.dp, 10.dp))
                ExpandableOrderTable(historylist2, "История справок для военкомата")
                Spacer(modifier = Modifier.size(20.dp, 100.dp))
            }

        }

    }else{
        LoadingScreen()
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
        val stages = listOf("Создано", "В работе", "На подписании", "Готова")

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
                                if (currentStage < 0) {
                                    Color.Gray
                                } else if (index <= currentStage) Color.Green else Color.Gray,
                                shape = CircleShape
                            )
                    )

                }
            }
        }
    }

@Composable
fun OrderTable(orderStatus: TypeStatusList) {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        TextInLazyColumns(
            columnName = orderStatus.Date,
            modifier = Modifier.weight(.25f),
            style = MaterialTheme.typography.bodySmall
        )
        TextInLazyColumns(
            columnName = orderStatus.TypeOrder,
            modifier = Modifier.weight(0.25f),
            style = MaterialTheme.typography.bodySmall
        )
        TextInLazyColumns(
            columnName = orderStatus.CountOrder,
            modifier = Modifier.weight(0.25f),
            style = MaterialTheme.typography.bodySmall
        )
        TextInLazyColumns(
            columnName = orderStatus.Status,
            modifier = Modifier.weight(0.25f),
            style = MaterialTheme.typography.bodySmall
        )
    }
    /*Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        //Text("NumberOrder: ${orderStatus.NumberOrder}")
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(orderStatus.Date, textAlign = TextAlign.Center)
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(horizontalArrangement = Arrangement.Center) {
                Text(orderStatus.TypeOrder, textAlign = TextAlign.Center)
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(horizontalArrangement = Arrangement.Center) {
                Text(orderStatus.CountOrder, textAlign = TextAlign.Center)
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row (horizontalArrangement = Arrangement.Center){
                Text(orderStatus.Status, textAlign = TextAlign.Center)
            }
        }
    }*/
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderTableOne() {
    /* Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text("Дата", textAlign = TextAlign.Center)
        Text("Тип", textAlign = TextAlign.Center)
        Text("Кол во", textAlign = TextAlign.Center)
        Text("Статус", textAlign = TextAlign.Center)

        /*Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text("Дата", textAlign = TextAlign.Center)
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text("       Тип", textAlign = TextAlign.Center)
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text("    Кол-во", textAlign = TextAlign.Center)
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text("Статус", textAlign = TextAlign.Center)
            }
        }*/
    }*/
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .height(30.dp)) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                TextInLazyColumns(
                    columnName = "Дата",
                    modifier = Modifier.weight(.25f),
                    style = MaterialTheme.typography.bodySmall
                )
                TextInLazyColumns(
                    columnName = "Тип",
                    modifier = Modifier.weight(0.25f),
                   style = MaterialTheme.typography.bodySmall
                )
                TextInLazyColumns(
                    columnName = "Кол-во",
                    modifier = Modifier.weight(0.25f),
                    style = MaterialTheme.typography.bodySmall
                )
                TextInLazyColumns(
                    columnName = "Статус",
                    modifier = Modifier.weight(0.25f),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                color = Color.White,
                thickness = 1.dp
            )

        }
    }
}

@Composable
fun ExpandableOrderTable(orderStatus: List<TypeStatusList>, hystoryType: String) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier.clickable { expanded = !expanded }
        ) {
            Text(hystoryType)
            Icon(
                imageVector = if (expanded)
                    Icons.Default.KeyboardArrowDown
                else
                    Icons.Default.KeyboardArrowUp,
                contentDescription = "Expand/Collapse"
            )
        }
        if (expanded) {
            OrderTableOne()
            orderStatus.map {
                OrderTable(it)
            }
        }
    }
}

@Composable
fun TextInLazyColumns(
    columnName: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            text = columnName, style = style, textAlign = TextAlign.Center
        )
    }
}


