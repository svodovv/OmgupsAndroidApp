package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
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
                            .fillMaxSize()
                            .padding(start = 8.dp, end = 8.dp)
                    ) {
                        TextInLazyColumn(
                            columnName = "Период",
                            modifier = Modifier.weight(1.5f),
                            style = MaterialTheme.typography.bodySmall
                        )
                        TextInLazyColumn(
                            columnName = "Тип выплаты",
                            modifier = Modifier.weight(1.7f),
                            style = MaterialTheme.typography.bodySmall
                        )
                        TextInLazyColumn(
                            columnName = "Курс",
                            modifier = Modifier.weight(1.2f),
                            style = MaterialTheme.typography.bodySmall
                        )
                        TextInLazyColumn(
                            columnName = "Сумма",
                            modifier = Modifier.weight(0.7f),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        color = MaterialTheme.colorScheme.inverseSurface,
                        thickness = 1.dp
                    )
                }

                itemsIndexed(scholarship.value.scholarshipList) { index, it ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp)
                            .background(
                                color = if (index % 2 == 0) {
                                    MaterialTheme.colorScheme.background
                                } else {
                                    MaterialTheme.colorScheme.inverseOnSurface
                                }
                            ), verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextInLazyColumn(
                            columnName = it.dateInterval, modifier = Modifier.weight(1.5f)
                        )
                        TextInLazyColumn(
                            columnName = it.typeOfPayment, modifier = Modifier.weight(1.7f)
                        )
                        TextInLazyColumn(columnName = it.year, modifier = Modifier.weight(1.2f))
                        TextInLazyColumn(columnName = it.sum, modifier = Modifier.weight(0.7f))
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        thickness = 1.dp
                    )
                }
                scholarship.value.totalSum?.let {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Общая сумма: ${it.totalSum}",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start
                            )
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
fun TextInLazyColumn(
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