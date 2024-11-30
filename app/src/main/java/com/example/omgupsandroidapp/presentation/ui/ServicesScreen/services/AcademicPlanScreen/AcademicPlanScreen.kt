package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar

@Composable
fun AcademicPlanScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    academicPlanViewModel: AcademicPlanViewModel = hiltViewModel()
) {
    ServicesTopAppBar(title = "Учебный план", navController = navController)

    val academicPlanState = academicPlanViewModel.academicPlanState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Text(text = "PLAN SCREEN")
        //academicPlanState.value.AcademicPlanList.map { Text(text = it.toString()) }

    }
}