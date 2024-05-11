package com.omgupsapp.presentation.ui.homeScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.ServicesViewModel


@Composable
fun ServiceScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    servicesViewModel: ServicesViewModel = hiltViewModel()
) {
    val serviceList = servicesViewModel.serviceList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        serviceList.forEach {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
                    .clickable {
                        navController.navigate(it.route)
                    }
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
                        modifier = Modifier.weight(5f),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(50.dp))
    }

}