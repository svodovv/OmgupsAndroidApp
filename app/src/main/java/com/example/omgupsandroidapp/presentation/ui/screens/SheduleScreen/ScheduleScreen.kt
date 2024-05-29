package com.omgupsapp.presentation.ui.SheduleScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.omgupsandroidapp.domain.model.service.SheduleModel
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.ScholarshipScreen.TextInLazyColumn
import com.example.omgupsandroidapp.presentation.ui.screens.SheduleScreen.SheduleViewModul
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale

/*@Composable
fun ScheduleScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    sheduleViewModul: SheduleViewModul = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        sheduleViewModul.getShedule()
    }

    val sheduleState = sheduleViewModul.sheduleState.collectAsStateWithLifecycle()
    val nechet = sheduleState.value.sheduleList.filter { it.type_of_week == 0 }
    val chet = sheduleState.value.sheduleList.filter { it.type_of_week == 1 }
    val dayOfWeek = listOf("Понедельник", "Вторник")

    val currentDay = remember { mutableStateOf(dayOfWeek) }

    Column(
        modifier = Modifier
            .padding(0.dp, 40.dp)
            .fillMaxWidth() // Изменено с fillMaxSize на fillMaxWidth
    ) {
        Text("Нечетная неделя")

        LazyColumn(
            modifier = Modifier.fillMaxWidth(), // Убедитесь, что высота ограничена
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            nechet.forEach { items ->
                item(key = currentDay) {
                    Box(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxWidth() // Изменено с fillMaxSize на fillMaxWidth
                            .height(200.dp) // Добавлено ограничение высоты
                            .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                    ) {
                        Text(text = currentDay.value[0])
                        when (items.time) {
                            0 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
                                ) {
                                    Row {
                                        Text("8:00")
                                    }
                                    Row {
                                        Text("9:35")
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.75f)
                                ) {
                                    Row {
                                        Text(items.subj)
                                    }
                                }
                            }
                            // Остальные случаи
                        }
                    }
                }
            }
        }
    }
}*/
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ScheduleScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    sheduleViewModul: SheduleViewModul = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        sheduleViewModul.getShedule()
    }

    val sheduleState = sheduleViewModul.sheduleState.collectAsStateWithLifecycle()

    val nechet = sheduleState.value.sheduleList.filter { it.type_of_week == 0 }
    val chet = sheduleState.value.sheduleList.filter { it.type_of_week == 1 }
    val dayOfWeek = listOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота")


    LazyColumn(
        modifier = Modifier
            .padding(0.dp, 60.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxSize().padding(15.dp,0.dp)
                ) {
                    Text("Нечетная неделя", fontSize = 25.sp)
                }
                dayOfWeek.map { dayWeek ->
                    val days = nechet.filter { it.day_of_week == dayWeek }
                    Row {
                        createDayBox(dayOfWeek = dayWeek, schedule = days)
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxSize().padding(15.dp,0.dp)
                ) {
                    Text("Четная неделя", fontSize = 25.sp)
                }
                dayOfWeek.map { dayWeek ->
                    val days = chet.filter { it.day_of_week == dayWeek }
                    Row {
                        createDayBox(dayOfWeek = dayWeek, schedule = days)
                    }
                }
            }
        }
    }
}

@Composable
fun createDayBox(dayOfWeek: String, schedule: List<SheduleModel>) {
    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxSize(1f)
            .background(color = Color(0xFF3D6CB9), shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 10.dp),

        ) {
            Text(dayOfWeek, fontSize = 20.sp)
        }
        for (scheduleItem in schedule) {
            when (scheduleItem.time) {
                0 -> Row {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("8:0")
                        }
                        Row {
                            Text("9:35")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFBAEAFF)
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }

                1 -> Row {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("9:45")
                        }
                        Row {
                            Text("11:20")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFBAEAFF)
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }

                2 -> Row {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("11:30")
                        }
                        Row {
                            Text("13:05")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFBAEAFF)
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }

                3 -> Row {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("13:55")
                        }
                        Row {
                            Text("15:30")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFBAEAFF)
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }

                4 -> Row {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("15:40")
                        }
                        Row {
                            Text("17:15")
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFBAEAFF)
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }
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

@Composable
fun OneDayShedule(
    day_of_week: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxSize(1f)
            .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Row {
                    Text(text = day_of_week)
                }

            }
        }
    }

}

fun getCurrentDate(): String {
    val calendar = Calendar.getInstance()
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val day_of_week = calendar.get(Calendar.DAY_OF_WEEK)
    val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
    val year = calendar.get(Calendar.YEAR)
    return "$day." + "$month"
}

