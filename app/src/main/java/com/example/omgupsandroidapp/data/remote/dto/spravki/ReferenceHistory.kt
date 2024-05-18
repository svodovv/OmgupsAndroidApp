package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.google.gson.annotations.SerializedName

data class ReferenceHistoryDto(
    //@SerializedName("OrderStatus")
    val historyStatus: List<TypeStatusList>
)

data class ReferenceHistoryDtoItem (
    @SerializedName("CountOrder")
    val CountOrder: String,
    @SerializedName("Date")
    val Date: String,
    @SerializedName("NumberOrder")
    val NumberOrder: String,
    @SerializedName("Status")
    val Status: String,
    @SerializedName("TypeOrder")
    val TypeOrder: String
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
