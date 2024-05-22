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
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.ScholarshipScreen.TextInLazyColumn
import com.example.omgupsandroidapp.presentation.ui.screens.SheduleScreen.SheduleViewModul
import kotlinx.coroutines.launch
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



    LazyColumn(
        modifier = Modifier
            .padding(0.dp, 40.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            sheduleState.value.sheduleList.map {
                Row{
                    Text("Нечетная неделя")
                }
                Box(
                    modifier = Modifier
                        .padding(10.dp, 10.dp)
                        .fillMaxSize(1f)
                        .background(color = Color.Black, shape = RoundedCornerShape(16.dp))
                ){
                    Column {
                        Text("Понедельник")

                        Text("Вторник")

                        Text("Понедельник")

                        Text("Понедельник")
                    }
                }
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

            }
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
){
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
        ){
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
    return "$day."+"$month"
}

