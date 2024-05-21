package com.omgupsapp.presentation.ui.SheduleScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Schedule screen")

        if(sheduleState.value.sheduleList.isNotEmpty()){
            sheduleState.value.sheduleList.map {
                Text(text = it.subj)
                Text(text = it.day_of_week)
                Text(text = it.type_of_week.toString())
            }
        }
    }
}


