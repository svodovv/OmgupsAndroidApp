package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScholarshipScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    scholarshipViewModel: ScholarshipViewModel = hiltViewModel()
) {

    val scholarship = scholarshipViewModel.scholarship.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        ServicesTopAppBar(title = "Выплаты", navController = navController)

        if (scholarship.value.scholarshipList.isNotEmpty()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                stickyHeader {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp)
                    ) {
                        RowInStickyHeader(columnName = "Дата приказа", modifier = Modifier.weight(1.5f))
                        RowInStickyHeader(columnName = "Тип выплаты", modifier = Modifier.weight(2f))
                        RowInStickyHeader(columnName = "Курс", modifier = Modifier.weight(1.2f))
                        RowInStickyHeader(columnName = "Сумма", modifier = Modifier.weight(0.7f))
                    }
                    Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
                }

                items(scholarship.value.scholarshipList) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Text(text = it.date, modifier = Modifier
                            .weight(1.5f)
                            .padding(1.dp)
,
                            style = MaterialTheme.typography.bodySmall)
                        Text(text = it.typeOfPayment, modifier = Modifier
                            .weight(2f)
                            .padding(1.dp), style = MaterialTheme.typography.bodySmall)
                        Text(text = it.year, modifier = Modifier
                            .weight(1.2f)
                            .padding(1.dp), style = MaterialTheme.typography.bodySmall)
                        Text(text = it.sum, modifier = Modifier
                            .weight(0.7f)
                            .padding(1.dp), style = MaterialTheme.typography.bodySmall)
                    }
                    Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
                }
            }
        } else {
            LoadingScreen()
        }

    }
}

@Composable
fun RowInStickyHeader(
    columnName: String, modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = columnName, style = MaterialTheme.typography.bodySmall)
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.Red)
        )
    }
}
