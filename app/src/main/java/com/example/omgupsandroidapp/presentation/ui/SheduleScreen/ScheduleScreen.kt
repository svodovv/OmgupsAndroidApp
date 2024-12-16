package com.omgupsapp.presentation.ui.SheduleScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.domain.model.service.SheduleModel
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.SheduleScreen.SheduleViewModul
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar
import java.util.Locale

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            //.padding(2.dp)
    ) {
        Log.e("htmlContent", sheduleState.value.sheduleList.toString())

        //ServicesTopAppBar(title = "Расписание", navController = navController)
        if (sheduleState.value.sheduleList.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .padding(0.dp, 60.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Column() {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp, 0.dp)
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
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp, 0.dp)
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
        } else {
            LoadingScreen()
        }
    }
}

@Composable
fun createDayBox(dayOfWeek: String, schedule: List<SheduleModel>) {
    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxSize(1f)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 10.dp),

            ) {

            Text(getCurrentDate(dayOfWeek), fontSize = 20.sp)
        }
        for (scheduleItem in schedule) {
            when (scheduleItem.time) {
                0 -> Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("8:00")
                        }
                        Row {
                            Text("9:35")
                        }
                    }
                    VerticalDivider(
                        Modifier
                            .width(0.dp)
                            .height(38.dp)
                            .border(width = 2.dp, MaterialTheme.colorScheme.primaryContainer)
                    )
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
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                )
                        ) {
                            //val sh = scheduleItem.subj.substringBefore(" a.")
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }

                1 -> OneDayShedule("9:45","11:20", scheduleItem)


                2 -> OneDayShedule("11:30","13:05", scheduleItem)


                3 -> OneDayShedule("13:55","15:30", scheduleItem)


                4 -> OneDayShedule("15:40","17:15", scheduleItem)/*Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        VerticalDivider(
                            modifier = Modifier
                                .width(1.dp)
                                .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                            thickness = 10.dp,
                            color = Color.Black
                        )
                    }
                    VerticalDivider(
                        Modifier
                            .width(0.dp)
                            .height(38.dp)
                            .border(width = 2.dp, MaterialTheme.colorScheme.primaryContainer)
                    )
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
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }*/
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
    beginTime : String,
    endingTime: String,
    scheduleItem : SheduleModel,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
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
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                thickness = 10.dp,
                color = Color.Black
            )
        }
        VerticalDivider(
            Modifier
                .width(0.dp)
                .height(38.dp)
                .border(width = 2.dp, MaterialTheme.colorScheme.primaryContainer)
        )
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
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
            ) {
                Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
            }
        }
    }

}

@Composable
fun getCurrentDate(currentDay:String): String {
    val calendar = Calendar.getInstance()
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    var dayresult by remember {
        mutableStateOf("")
    }
    when(currentDay){
        "Понедельник" -> dayresult = "${day.plus(0)}.Понедельник"
        "Вторник" -> dayresult =  "${day.plus(1)}.Вторник"
        "Среда" -> dayresult = "${day.plus(2)}.Cреда"
        "Четверг" -> dayresult = "${day.plus(3)}.Четверг"
        "Пятница" ->dayresult =  "${day.plus(4)}.Пятница"
        "Суббота" ->dayresult =  "${day.plus(5)}.4Суббота"
    }
    return dayresult


   /* val day_of_week =  LocalDate.now().dayOfWeek.name
    val time = LocalDate.now().atTime(LocalTime.now())
    val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
    val year = calendar.get(Calendar.YEAR)*/
        // return "$day." + "$day_of_week" + "$time"
}