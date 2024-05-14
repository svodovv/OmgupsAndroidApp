package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.google.gson.annotations.SerializedName

data class ReferenceHistoryDto(
    @SerializedName("OrderStatus")
    val historyStatus: TypeStatusList
)

fun ReferenceHistoryDtoItem.toReferenceHistoryModel(): TypeStatusList {
    return TypeStatusList(
        CountOrder = CountOrder,
        Date = Date,
        NumberOrder = NumberOrder,
        Status = Status,
        TypeOrder = TypeOrder
    )
}
