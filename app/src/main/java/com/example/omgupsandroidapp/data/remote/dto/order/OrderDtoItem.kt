package com.example.omgupsandroidapp.data.remote.dto.order

import com.example.omgupsandroidapp.domain.model.service.OrderModel

data class OrderDtoItem(
    val ordersTitle: List<String>,
    val spec: String
)

fun OrderDtoItem.toOrderModel(): OrderModel {
    return OrderModel(
        orderList = ordersTitle,
        orderTitle = spec
    )
}