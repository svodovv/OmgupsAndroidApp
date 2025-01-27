package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.GradeBook

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.NoData.NoDataScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar

@Composable
fun StudentBookScreen(
    navController: NavController, paddingValues: PaddingValues,
    gradeBooksViewModel: GradeBooksViewModel = hiltViewModel()
) {
    val gradeBooks = gradeBooksViewModel.gradeBookState.collectAsStateWithLifecycle()
    //NoDataScreen()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Log.i("gradeBookList", gradeBooks.value.toString())
        gradeBooks.value.gradeBookList.map {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(text = it.form)
                }
            }
        }

    }

}