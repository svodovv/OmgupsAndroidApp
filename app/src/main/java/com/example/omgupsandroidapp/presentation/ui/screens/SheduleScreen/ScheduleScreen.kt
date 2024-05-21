package com.omgupsapp.presentation.ui.SheduleScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.screens.SheduleScreen.SheduleViewModul
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ScheduleScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    sheduleViewModul: SheduleViewModul = hiltViewModel()
) {

    val sheduleState = sheduleViewModul.sheduleState.collectAsStateWithLifecycle()
    sheduleViewModul.viewModelScope.launch {
        sheduleViewModul.getShedule()
    }


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            if (sheduleState.value.sheduleList.isNotEmpty()) {
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
            }
        }
    }
}


