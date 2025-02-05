package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
///import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.NoData.NoDataScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import com.my.tracker.MyTracker
import kotlinx.coroutines.launch



@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpravkaScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    spravkiViewModel: SpravkiViewModel = hiltViewModel(),
    referenceHistoryViewModel : ReferenceHistoryViewModel = hiltViewModel(),
    spravkaViewModul: StatusSpravkaViewModul = hiltViewModel(),
    orderSpravkaViewModel: OrderSpravkaViewModel = hiltViewModel()

) {

    MyTracker.trackEvent("Заказ справок")
    var InputSpravka0 by remember { mutableStateOf("0") }
    var InputSpravka1 by remember { mutableStateOf("0") }
    var expanded_1 by remember { mutableStateOf(false) }
    var expanded_2 by remember { mutableStateOf(false) }

    val referenceHistory = referenceHistoryViewModel.referenceHistoryState.collectAsStateWithLifecycle()
   // val spravka = orderSpravkaViewModel.orderSpravka.collectAsStateWithLifecycle()
    val statusSpravki = spravkaViewModul.status.collectAsStateWithLifecycle()
    val types = spravkiViewModel.spravkiState.value
    //val history = referenceHistoryViewModel.referenceHistoryState.value
    var stasus0 = statusSpravki.value.spravkiStatus0
    var stasus1 = statusSpravki.value.spravkiStatus1
    val historylist1 = referenceHistory.value.referenceHistoryList0
    val historylist2 = referenceHistory.value.referenceHistoryList1
    val spravki = spravkiViewModel.spravkiState.collectAsStateWithLifecycle()

    val mapStatus = mapOf(
        "Нет:Заявка уже подана." to 0,
        "Да:Создано" to 1,
        "Да:Заявка создана." to 1,
        "Да:В работе" to 2,
        "Да:На подписании" to 3,
        "Да:К выдаче" to 4,
        "Да:Передано в военкомат" to 4)

    var indStatus0 by remember { mutableIntStateOf(0) }
    var indStatus1 by remember { mutableIntStateOf(0) }

    /*var listhistor = listOf(
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент"),
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент"),
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент"),
        TypeStatusList("2", "23.10.2023", "00", "Создано", "Военная"),
        TypeStatusList("2", "23.10.2023", "00", "В работе", "Студент")
    )*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(paddingValues)
    )
    {
        ServicesTopAppBar(title = "Заказать справку", navController = navController)

        if (spravki.value.spravkiList.isNotEmpty() &&
            statusSpravki.value.spravkiStatus0.isNotEmpty() &&
            statusSpravki.value.spravkiStatus1.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .padding(8.dp, 8.dp)
                            //.fillMaxSize()
                        // .weight(0.2f)
                    ) {
                        Box(
                            modifier = Modifier
                                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                .fillMaxSize()
                        )
                        {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Spacer(modifier = Modifier.padding(5.dp))
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
                                    /*ExposedDropdownMenuBox(
                                    expanded = expanded,
                                    onExpandedChange = {
                                        expanded = !expanded
                                    }
                                ) {
                                    TextField(
                                        value = selectedText,
                                        onValueChange = {InputSpravka0},
                                        readOnly = true,
                                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                                        modifier = Modifier.fillMaxWidth(.2f)
                                    )

                                    ExposedDropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false }
                                    ) {
                                        coffeeDrinks.forEach { item ->
                                            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                                                DropdownMenuItem(onClick = { InputSpravka0 = 1.toString() },
                                                    text = { Text(item) }
                                                )
                                                //Divider()
                                                DropdownMenuItem(onClick = { InputSpravka0 = 2.toString()  },
                                                    text = { Text(item) }
                                                )

                                            }
                                        }
                                    }
                                }*/


                                    ExposedDropdownMenuBox(
                                        expanded = expanded_1,
                                        onExpandedChange = {
                                            expanded_1 = it
                                        },
                                        modifier = Modifier
                                            .border(
                                                2.dp,
                                                shape = RoundedCornerShape(10.dp),
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                    ) {
                                        TextField(
                                            value = InputSpravka0,
                                            onValueChange = { },
                                            readOnly = true,
                                            trailingIcon = {
                                                ExposedDropdownMenuDefaults.TrailingIcon(
                                                    expanded = expanded_1
                                                )
                                            },
                                            colors = ExposedDropdownMenuDefaults.textFieldColors(
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent,
                                                unfocusedContainerColor = Color.Transparent,
                                                focusedContainerColor = Color.Transparent
                                            ),
                                            modifier = Modifier
                                                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                                //.fillMaxWidth(.25f)
                                                .size(90.dp, 55.dp)
                                                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                                        )
                                        /*IconButton(onClick = { expanded = true }) {
                                                     Icon(Icons.Default., contentDescription = "Показать меню")
                                                 }*/
                                        ExposedDropdownMenu(
                                            expanded = expanded_1,
                                            onDismissRequest = { expanded_1 = false },
                                            modifier = Modifier
                                                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                        ) {
                                            DropdownMenuItem(onClick = {
                                                InputSpravka0 = "1"
                                                expanded_1 = false
                                            },
                                                text = { Text("1") },
                                                modifier = Modifier.size(90.dp,40.dp)
                                            )
                                            HorizontalDivider()
                                            DropdownMenuItem(onClick = {
                                                InputSpravka0 = "2"
                                                expanded_1 = false
                                            },
                                                text = { Text("2") },
                                                modifier = Modifier.size(90.dp,40.dp)
                                            )
                                        }
                                    }


                                    /*OutlinedTextField(
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
                                            stringResource(R.string.Kol_vo),
                                            fontSize = 16.sp,
                                            color = Color.Black,
                                        )
                                    },
                                )*/
                                    /*Button(
                                        modifier = Modifier
                                            .fillMaxWidth(.45f),
                                        onClick = {
                                            GlobalScope.async {
                                            stastusAfterOrderSpravka =
                                                orderSpravkaViewModel.postSravka(
                                                    LoadSpravka(
                                                        types.spravkiList[0].ID,
                                                        InputSpravka0.toInt()
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
                                            Log.i(
                                                "StastusAfterOrderSpravka",
                                                stastusAfterOrderSpravka
                                            )
                                        }
                                    ) {
                                        Text(text = "Заказать")
                                    }*/
                                    /*Button(
                                        modifier = Modifier
                                            .fillMaxWidth(.45f),
                                        onClick = {
                                            var stastusAfterOrderSpravka =
                                                orderSpravkaViewModel.postSravka(
                                                    LoadSpravka(
                                                        types.spravkiList[0].ID,
                                                        InputSpravka0.toInt()
                                                    )
                                                ).toString()
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
                                            Log.i(
                                                "StastusAfterOrderSpravka",
                                                stastusAfterOrderSpravka
                                            )
                                        }
                                    ) {
                                        Text(text = "Заказать")
                                    }*/
                                    Button(
                                        modifier = Modifier.size(120.dp,40.dp),
                                        onClick = {
                                            orderSpravkaViewModel.viewModelScope.launch {
                                                // Первый запрос
                                                val statusAfterOrderSpravka = orderSpravkaViewModel.postSravka(
                                                    LoadSpravkaDto(
                                                        types.spravkiList[0].ID,
                                                        InputSpravka0.toInt()
                                                    )
                                                )
                                                Log.i("StatusAfterOrderSpravka", statusAfterOrderSpravka)
                                                stasus0 = statusAfterOrderSpravka
                                                Log.i("stasus0", stasus0)
                                                mapStatus.forEach{
                                                    if (it.key == stasus0)
                                                        indStatus0 = it.value
                                                }
                                                Log.i("indStatus0", indStatus0.toString())
                                            }
                                        }
                                    ) {
                                        Text(text = "Заказать")
                                    }
                                }
                                mapStatus.forEach{
                                    if (it.key == stasus0)
                                        indStatus0 = it.value
                                }
                                /*mapStatus.forEach{
                                   if (it.key == stasus0)
                                        indStatus0 = it.value
                                }*/
                                    // Log.i("indStatus0", indStatus0.toString())
                                /*for ((i, element) in listStatusSpravka.withIndex()) {
                                    if (element == stasus0) {
                                        indStatus0 = i
                                        break
                                    }
                                }*/
                                /*if (indStatus0 != -1) {
                                    Log.i("TAAAAG", "Индекс совпадающего элемента: $indStatus0")
                                } else {
                                    //      Log.i("TAAAAG",referenceHistory.value.referenceHistoryList[0].Status )
                                    Log.i("TAAAAG", stasus0)


                                }*/
                                Spacer(modifier = Modifier.size(20.dp, 20.dp))
                                Log.i("TAAAAG", "Индекс совпадающего элемента: $indStatus0")
                                OrderStatusBar(indStatus0 - 1)
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .padding(8.dp, 8.dp)
                        //.weight(0.2f)
                    ) {
                        Box(
                            modifier = Modifier
                                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                .fillMaxSize()
                        )
                        {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Spacer(modifier = Modifier.padding(5.dp))
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
                                    /*OutlinedTextField(
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
                                                stringResource(R.string.Kol_vo),
                                                fontSize = 16.sp,
                                                color = Color.Black,
                                            )
                                        },
                                    )*/
                                    ExposedDropdownMenuBox(
                                        expanded = expanded_2,
                                        onExpandedChange = {
                                            expanded_2 = it
                                        },
                                        modifier = Modifier
                                            .border(
                                                2.dp,
                                                shape = RoundedCornerShape(10.dp),
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                    ) {
                                        TextField(
                                            value = InputSpravka1,
                                            onValueChange = { },
                                            readOnly = true,
                                            trailingIcon = {
                                                ExposedDropdownMenuDefaults.TrailingIcon(
                                                    expanded = expanded_2
                                                )
                                            },
                                            colors = ExposedDropdownMenuDefaults.textFieldColors(
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent,
                                                unfocusedContainerColor = Color.Transparent,
                                                focusedContainerColor = Color.Transparent
                                            ),
                                            modifier = Modifier
                                                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                                .size(90.dp, 55.dp)
                                                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                                        )
                                        /*IconButton(onClick = { expanded = true }) {
                                                     Icon(Icons.Default., contentDescription = "Показать меню")
                                                 }*/
                                        ExposedDropdownMenu(
                                            expanded = expanded_2,
                                            onDismissRequest = { expanded_2 = false },
                                            modifier = Modifier
                                                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                                        ) {
                                            DropdownMenuItem(onClick = {
                                                InputSpravka1 = "1"
                                                expanded_2 = false
                                            },
                                                text = { Text("1") },
                                                modifier = Modifier.size(90.dp,40.dp)
                                            )
                                            HorizontalDivider()
                                            DropdownMenuItem(onClick = {
                                                InputSpravka1 = "2"
                                                expanded_2 = false
                                            },
                                                text = { Text("2") },
                                                modifier = Modifier.size(90.dp,40.dp)
                                            )
                                        }
                                    }
                                   /* Button(
                                        modifier = Modifier
                                            .fillMaxWidth(.45f),
                                        onClick = {
                                            orderSpravkaViewModel.viewModelScope.launch {
                                                // Первый запрос
                                                val statusAfterOrderSpravka = orderSpravkaViewModel.postSravka(
                                                    LoadSpravka(
                                                        types.spravkiList[1].ID,
                                                        InputSpravka1.toInt()
                                                    )
                                                )
                                                Log.i("StatusAfterOrderSpravka", statusAfterOrderSpravka)
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
                                    }*/
                                    Button(
                                        modifier =  Modifier.size(120.dp,40.dp),
                                        onClick = {
                                            orderSpravkaViewModel.viewModelScope.launch {
                                                // Первый запрос
                                                val statusAfterOrderSpravka = orderSpravkaViewModel.postSravka(
                                                    LoadSpravkaDto(
                                                        types.spravkiList[1].ID,
                                                        InputSpravka1.toInt()
                                                    )
                                                )
                                                Log.i("StatusAfterOrderSpravka", statusAfterOrderSpravka)
                                                stasus1 = statusAfterOrderSpravka
                                                Log.i("stasus1", stasus1)
                                                mapStatus.forEach{
                                                    if (it.key == stasus1)
                                                        indStatus1 = it.value
                                                }
                                                Log.i("indStatus0", indStatus0.toString())
                                            }
                                        }
                                    ) {
                                        Text(text = "Заказать")
                                    }
                                }
                                mapStatus.forEach{
                                    if (it.key == stasus1)
                                        indStatus1 = it.value
                                }
                                /*for ((i, element) in listStatusSpravka.withIndex()) {
                                    if (element == stasus1) {
                                        indStatus1 = i
                                        break
                                    }
                                }
                                Log.i("Status1", "Статус: $stasus1")
                                Log.i("indStatus1", "Элемента: $indStatus1")
                                if (indStatus1 != -1) {
                                    Log.i("indStatus1", "Элемента: $indStatus1")
                                } else {
                                    //      Log.i("TAAAAG",referenceHistory.value.referenceHistoryList[0].Status )
                                    Log.i("TAAAAG", stasus0)
                                }*/
                                Spacer(modifier = Modifier.size(20.dp, 20.dp))
                                OrderStatusBar(indStatus1 - 1)
                                if (stasus1 == "Да:Передано в военкомат") {
                                    Row(
                                        Modifier.fillMaxSize(),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Text(text = "Передано в военкомат", color = Color.Black)
                                    }
                                    Spacer(modifier = Modifier.padding(4.dp))
                                }
                                //  OrderStatusBar(0, st)

                            }
                        }
                    }
                }
                item {
                   // Spacer(modifier = Modifier.size(10.dp, 5.dp))
                    Log.i("referenceHistoryViewModel", referenceHistoryViewModel.referenceHistoryState.value.error)
                    ExpandableOrderTable(historylist1, "История справок по обучению",referenceHistoryViewModel.referenceHistoryState.value.error)
                    //Spacer(modifier = Modifier.size(10.dp, 5.dp))
                   // ExpandableOrderTable(historylist2, "История справок для военкомата")
                    Spacer(modifier = Modifier.size(10.dp, 5.dp))
                }
            }
        } else {
            LoadingScreen()
        }
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo_ExposedDropdownMenuBox(InputSpravka: String) {
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("1", "2")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                coffeeDrinks.forEach { item ->
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        DropdownMenuItem(onClick = { InputSpravka = 1.toString() },
                            text = { Text(item) }
                        )
                        Divider()
                        DropdownMenuItem(onClick = { InputSpravka = 2.toString()  },
                            text = { Text(item) }
                        )

                    }
                }
            }
        }
    }
}*/
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
                    Row {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    if (currentStage < 0) {
                                        Color.Gray
                                    } else if (index == currentStage) Color.Blue else Color.Gray,
                                    shape = CircleShape
                                )
                        )
                        /*Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    if (currentStage < 0) {
                                        Color.Gray
                                    } else if (index <= currentStage) Color.Green else Color.Gray,
                                    shape = CircleShape
                                )
                        )*/
                    }
                }
            }
        }
    }

@Composable
fun OrderTable(orderStatus: TypeStatusList) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
    ) {
        TextInLazyColumns(
            columnName = orderStatus.Date,
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
@Composable
fun OrderTableOne() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(30.dp)) {
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
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpandableOrderTable(orderStatus: List<TypeStatusList>, hystoryType: String, HttpStatus: String) {
    var isVisible by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(top = 16.dp, start = 8.dp, end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = hystoryType)
                    /*TextWithDynamicLineBreak(
                        text = stringResource()
                    )*/
                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = { isVisible = !isVisible }) {
                        Icon(
                            painter = painterResource(
                                id = if (isVisible) R.drawable.baseline_keyboard_arrow_up_24
                                else R.drawable.baseline_keyboard_arrow_down_24
                            ),
                            contentDescription = stringResource(R.string.arrow_in_order_card),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                OrderTableOne()
            }
        if (HttpStatus == "HTTP 404 Not Found") {
            AnimatedVisibility(visible = isVisible) {
                NoDataScreen(idDrawable = R.drawable.ic_no_data)
            }
        }else
            orderStatus.map {
                AnimatedVisibility(visible = isVisible) {
                    OrderTable(it)
                }
            }
        Spacer(modifier = Modifier.padding(4.dp))
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


