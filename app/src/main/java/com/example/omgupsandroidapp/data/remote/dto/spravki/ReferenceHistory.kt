package com.example.omgupsandroidapp.data.remote.dto.spravki

data class ReferenceHistory(
    val OrderStatus: List<OrderStatusDto>
)

fun ReferenceHistoryDtoItem.toReferenceHistoryModel(): OrderStatusDto {
    return OrderStatusDto(
        CountOrder = this.CountOrder,
        Date = this.Date,
        NumberOrder = this.NumberOrder,
        Status = this.Status,
        TypeOrder = this.TypeOrder
    )
}
