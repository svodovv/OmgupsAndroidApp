package com.omgupsapp.presentation.ui.SheduleScreen

import android.annotation.SuppressLint
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
    val dayOfWeek = listOf("Понедельник", "Вторник","Среда","Четверг","Пятница","Суббота")
    val nechpon1 = nechet.filter { it.day_of_week == "Понедельник" }
    val nechpon2 = nechet.filter { it.day_of_week == "Вторник" }
    val nechpon3 = nechet.filter { it.day_of_week == "Среда" }
    val nechpon4 = nechet.filter { it.day_of_week == "Четверг" }
    val nechpon5 = nechet.filter { it.day_of_week == "Пятница" }
    val nechpon6 = nechet.filter { it.day_of_week == "Суббота" }
    val chet1 = nechet.filter { it.day_of_week == "Понедельник" }
    val chet2 = nechet.filter { it.day_of_week == "Вторник" }
    val chet3 = nechet.filter { it.day_of_week == "Среда" }
    val chet4 = nechet.filter { it.day_of_week == "Четверг" }
    val chet5 = nechet.filter { it.day_of_week == "Пятница" }
    val chet6 = nechet.filter { it.day_of_week == "Суббота" }

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
                Text("Нечетная неделя")

                for (it in dayOfWeek) {
                    when (it) {
                        "Понедельник" -> Row {
                            createDayBox(dayOfWeek = it, schedule = nechpon1)
                        }
                        "Вторник" -> Row {
                            createDayBox(dayOfWeek = it, schedule = nechpon2)
                        }
                        "Среда" -> Row {
                            createDayBox(dayOfWeek = it, schedule = nechpon3)
                        }
                        "Четверг" -> Row {
                            createDayBox(dayOfWeek = it, schedule = nechpon4)
                        }
                        "Пятница" -> Row {
                            createDayBox(dayOfWeek = it, schedule = nechpon5)
                        }
                        "Суббота" -> Row {
                            createDayBox(dayOfWeek = it, schedule = nechpon6)
                        }
                    }
                }
                Text("Четная неделя")
                for (it in dayOfWeek) {
                    when (it) {
                        "Понедельник" -> Row {
                            createDayBox(dayOfWeek = it, schedule = chet1)
                        }
                        "Вторник" -> Row {
                            createDayBox(dayOfWeek = it, schedule = chet2)
                        }
                        "Среда" -> Row {
                            createDayBox(dayOfWeek = it, schedule = chet3)
                        }
                        "Четверг" -> Row {
                            createDayBox(dayOfWeek = it, schedule = chet4)
                        }
                        "Пятница" -> Row {
                            createDayBox(dayOfWeek = it, schedule = chet5)
                        }
                        "Суббота" -> Row {
                            createDayBox(dayOfWeek = it, schedule = chet6)
                        }
                    }
                }
            }

                    /*"Понедельник" -> Box(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(1f)
                            .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                    ) {
                        Text("Понедельник")
                        when (it.time) {
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
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            1 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            2 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            3 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            4 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                        }
                    }

                    "Вторник" -> Box(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(1f)
                            .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                    ) {
                        Text("Вторник")
                        when (it.time) {
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
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            1 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            2 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            3 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }

                            4 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                        }
                    }
                    /*"Среда" -> Box(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(1f)
                            .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                    ) {
                        Text("Среда")
                        when (it.time) {
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
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            1 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            2 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            3 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            4 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                        }
                    }
                    "Четверг" -> Box(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(1f)
                            .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                    ) {
                        Text("Четверг")
                        when (it.time) {
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
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            1 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            2 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            3 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            4 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                        }
                    }
                    "Пятница" -> Box(
                            modifier = Modifier
                                .padding(10.dp, 10.dp)
                                .fillMaxSize(1f)
                                .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                        ) {
                            Text("Пятница")
                            when (it.time) {
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
                                    )
                                    {
                                        Row {
                                            Text(it.subj)
                                        }
                                    }
                                }
                                1 -> Row {
                                    Column(
                                        modifier = Modifier
                                            .padding(10.dp, 10.dp)
                                            .fillMaxSize(.25f)
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
                                            .fillMaxSize(.75f)
                                    )
                                    {
                                        Row {
                                            Text(it.subj)
                                        }
                                    }
                                }
                                2 -> Row {
                                    Column(
                                        modifier = Modifier
                                            .padding(10.dp, 10.dp)
                                            .fillMaxSize(.25f)
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
                                            .fillMaxSize(.75f)
                                    )
                                    {
                                        Row {
                                            Text(it.subj)
                                        }
                                    }
                                }
                                3 -> Row {
                                    Column(
                                        modifier = Modifier
                                            .padding(10.dp, 10.dp)
                                            .fillMaxSize(.25f)
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
                                            .fillMaxSize(.75f)
                                    )
                                    {
                                        Row {
                                            Text(it.subj)
                                        }
                                    }
                                }
                                4 -> Row {
                                    Column(
                                        modifier = Modifier
                                            .padding(10.dp, 10.dp)
                                            .fillMaxSize(.25f)
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
                                            .fillMaxSize(.75f)
                                    )
                                    {
                                        Row {
                                            Text(it.subj)
                                        }
                                    }
                                }
                            }
                        }
                    "Суббота" -> Box(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(1f)
                            .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                    ) {
                        Text("Суббота")
                        when (it.time) {
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
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            1 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            2 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            3 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                            4 -> Row {
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp, 10.dp)
                                        .fillMaxSize(.25f)
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
                                        .fillMaxSize(.75f)
                                )
                                {
                                    Row {
                                        Text(it.subj)
                                    }
                                }
                            }
                        }
                    }*/
                }
            }*/


                    /* Column {
               Row {
                            }
                            Row {
                                Text(text = it.subj + " предмет")
                            }
                            Row {
                                Text(text = it.day_of_week + " день недели")
                            }
                            Row {
                                Text(text = it.type_of_week.toString() + " неделя")
                            }
                            Row {
                                Text(text = it.time.toString() + " какая пара")
                            }
                    Row {
                        Text(text = sheduleState.value.sheduleList[0].id.toString() + " айди")
                    }
                    Row {
                        Text(text = sheduleState.value.sheduleList[0].subj + " предмет")
                    }
                    Row {
                        Text(text = sheduleState.value.sheduleList[0].day_of_week + " день недели")
                    }
                    Row {
                        Text(text = sheduleState.value.sheduleList[0].type_of_week.toString() + " неделя")
                    }
                    Row {
                        Text(text = sheduleState.value.sheduleList[0].time.toString() + " какая пара")
                    }
                }*/
                    /* if (sheduleState.value.sheduleList.isNotEmpty()) {
                sheduleState.value.sheduleList.map {
                    Box(
                        modifier = Modifier.background(color = Color.Black)
                    ) {
                        Text(text = it.id.toString() + "айди")
                        /*Text(text = it.subj + "предмет")
                        Spacer(modifier = Modifier.padding(0.dp,10.dp))
                        Text(text = it.day_of_week + "день недели")
                        Spacer(modifier = Modifier.padding(0.dp,10.dp))
                        Text(text = it.type_of_week.toString() + "неделя")
                        Spacer(modifier = Modifier.padding(0.dp,10.dp))
                        Text(text = it.type_of_week.toString() + "неделя")
                        Spacer(modifier = Modifier.padding(0.dp,10.dp))
                        Text(text = it.time.toString() + "какая пара")
                        Spacer(modifier = Modifier.padding(0.dp,10.dp))*/
                    }
                    Spacer(modifier = Modifier.padding(0.dp,20.dp))
                }
            }*/
                }
            }
        }
@Composable
fun createDayBox(dayOfWeek: String, schedule: List<SheduleModel>) {

        Column(
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxSize(1f)
                .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
        ) {
            Text(dayOfWeek)
            for (scheduleItem in schedule) {
                when (scheduleItem.time) {
                    0 -> Row {
                        Column(
                            modifier = Modifier
                                .padding(10.dp, 10.dp)
                                .fillMaxSize(.25f)
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
                                .fillMaxSize(.75f)
                        ) {
                            Row {
                                Text(scheduleItem.subj)
                            }
                        }
                    }

                    1 -> Row {
                        Column(
                            modifier = Modifier
                                .padding(10.dp, 10.dp)
                                .fillMaxSize(.25f)
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
                                .fillMaxSize(.75f)
                        ) {
                            Row {
                                Text(scheduleItem.subj)
                            }
                        }
                    }

                    2 -> Row {
                        Column(
                            modifier = Modifier
                                .padding(10.dp, 10.dp)
                                .fillMaxSize(.25f)
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
                                .fillMaxSize(.75f)
                        ) {
                            Row {
                                Text(scheduleItem.subj)
                            }
                        }
                    }

                    3 -> Row {
                        Column(
                            modifier = Modifier
                                .padding(10.dp, 10.dp)
                                .fillMaxSize(.25f)
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
                                .fillMaxSize(.75f)
                        ) {
                            Row {
                                Text(scheduleItem.subj)
                            }
                        }
                    }

                    4 -> Row {
                        Column(
                            modifier = Modifier
                                .padding(10.dp, 10.dp)
                                .fillMaxSize(.25f)
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
                                .fillMaxSize(.75f)
                        ) {
                            Row {
                                Text(scheduleItem.subj)
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

