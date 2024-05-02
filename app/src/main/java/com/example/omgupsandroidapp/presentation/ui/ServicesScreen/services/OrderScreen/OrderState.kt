package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.OrderScreen

import com.example.omgupsandroidapp.domain.model.service.OrderModel

data class OrderState(
    val orderList: List<OrderModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)