package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.OrderScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen.DynamicRowPage
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import com.my.tracker.MyTracker

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    orderViewModel: OrderViewModel = hiltViewModel()
) {
    val orderState = orderViewModel.orderState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { orderState.value.orderList.size })

    MyTracker.trackEvent("Приказы")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        ServicesTopAppBar(title = "Приказы", navController = navController)
        Column(
            Modifier
                .fillMaxSize()
        ) {
            if (pagerState.pageCount > 1) {
                Spacer(modifier = Modifier.padding(2.dp))
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color.Blue else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(12.dp)
                        )
                    }
                }
            }
           if (orderState.value.orderList.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    //contentAlignment = Alignment.Center
                ) {
                    HorizontalPager(
                        state = pagerState,
                        key = { orderState.value.orderList[it].orderTitle },
                    ) { index ->
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = orderState.value.orderList[index].orderTitle,
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier
                                        .padding(16.dp),
                                    maxLines = 2,
                                    minLines = 2,
                                    color = MaterialTheme.colorScheme.onBackground
                                )

                                HorizontalDivider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            horizontal = 8.dp,
                                        ), thickness = 1.dp, color = Color.Black
                                )
                                orderState.value.orderList[index].orderList.forEachIndexed { index, orderName ->
                                    Row(
                                        modifier = Modifier
                                            .padding(
                                                start = 8.dp, top = 8.dp, end = 8.dp
                                            )
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "${index + 1}.",
                                            style = MaterialTheme.typography.bodyLarge,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.weight(1f),
                                            color = MaterialTheme.colorScheme.onBackground
                                        )
                                        Text(
                                            text = orderName,
                                            style = MaterialTheme.typography.bodyLarge,
                                            textAlign = TextAlign.Start,
                                            modifier = Modifier.weight(11f),
                                            color = MaterialTheme.colorScheme.onBackground

                                        )
                                    }
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
}