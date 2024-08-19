package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
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
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                var isVisible by remember {
                    mutableStateOf(true)
                }
                LazyColumn(modifier = Modifier) {
                    stickyHeader {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 8.dp, end = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextWithDynamicLineBreak(
                                text = stringResource(R.string.pgas)
                            )
                            Spacer(
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { isVisible = !isVisible }) {
                                Icon(
                                    painter = painterResource(
                                        id = if (isVisible) R.drawable.baseline_keyboard_arrow_down_24
                                        else R.drawable.baseline_keyboard_arrow_up_24
                                    ),
                                    contentDescription = stringResource(R.string.arrow_in_order_card),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                    stickyHeader {
                        AnimatedVisibility(isVisible) {

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

                        }
                    }

                    itemsIndexed(scholarship.value.scholarshipList) { index, it ->
                        AnimatedVisibility(isVisible) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextInLazyColumn(
                                    columnName = it.dateInterval, modifier = Modifier.weight(1.5f)
                                )

                                TextInLazyColumn(
                                    columnName = it.year, modifier = Modifier.weight(1.2f)
                                )
                                TextInLazyColumn(
                                    columnName = it.sum, modifier = Modifier.weight(0.7f)
                                )
                            }
                        }
                    }
                    scholarship.value.totalSum?.let {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .then(
                                        if (isVisible) Modifier.padding(
                                            horizontal = 8.dp, vertical = 16.dp
                                        )
                                        else Modifier.padding(bottom = 8.dp)
                                    ),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Общая сумма: ${it.totalSum}",
                                    style = MaterialTheme.typography.bodySmall,
                                    textAlign = TextAlign.Start,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
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
private fun TextWithDynamicLineBreak(text: String) {
    // Разбиваем текст на слова
    val words = text.split(" ")

    // Если слов больше одного, переносим текст после первого слова
    val textWithLineBreak = if (words.size > 1) {
        words[0] + "\n" + words.subList(1, words.size).joinToString(" ")
    } else {
        text // Если только одно слово, возвращаем текст как есть
    }

    Text(
        text = textWithLineBreak,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
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
            text = columnName,
            style = style,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}