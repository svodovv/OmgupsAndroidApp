package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.OrderScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    orderViewModel: OrderViewModel = hiltViewModel()
) {
    val orderState = orderViewModel.orderState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { orderState.value.orderList.size })

    ServicesTopAppBar(title = "Приказы", navController = navController)

    if (orderState.value.orderList.isNotEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            HorizontalPager(
                state = pagerState,
                key = { orderState.value.orderList[it] },
                modifier = Modifier.fillMaxSize()
            ) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = orderState.value.orderList[index].orderTitle,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                        orderState.value.orderList[index].orderList.forEachIndexed() { index, orderName ->
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "$index.", style = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = orderName, style = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.weight(3f)
                                )
                            }
                        }
                    }
                }
            }
        }
    }else{
        LoadingScreen()
    }
}