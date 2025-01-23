package com.omgupsapp.presentation.ui.homeScreen.components

import android.content.Context
import androidx.collection.intFloatMapOf
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.ServicesViewModel
import com.example.omgupsandroidapp.presentation.utils.Event
import com.example.omgupsandroidapp.presentation.utils.RuStoreUpDateViewModel
import kotlinx.coroutines.launch


@Composable
fun ServiceScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    servicesViewModel: ServicesViewModel = hiltViewModel(),
    ruStoreUpDateViewModel : RuStoreUpDateViewModel = hiltViewModel()
) {
    val serviceList = servicesViewModel.serviceList
    val events by ruStoreUpDateViewModel.events.collectAsState(initial = null)


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            //.verticalScroll(rememberScrollState())
            .padding(paddingValues)
    ) {


        serviceList.forEach {
            item {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        ///.weight(1f)
                        .clickable {
                            navController.navigate(it.route)
                        }
                ) {
                    Box(
                        modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(start = 16.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Icon(
                                    painter = painterResource(id = it.selectedIcon),
                                    contentDescription = it.serviceName,
                                )
                            }
                            Text(
                                text = it.serviceName,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(3f),
                                textAlign = TextAlign.Start,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
        ruStoreUpDateViewModel.viewModelScope.launch {
            ruStoreUpDateViewModel.ruStoreAppUpdateManager.getAppUpdateInfo()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Text(text = "Статус обновления: $downloadProgress%")

        //Button(onClick = { viewModel.init(LocalContext.current) }) {
            Text(text = "Проверить обновление")
       // }

        if (events is Event.UpdateCompleted) {
            Text(text = "Обновление завершено!", color = Color.Green)
        }
    }
}
