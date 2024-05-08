package com.example.omgupsandroidapp.data.remote.dto.spravki

data class ReferenceHistoryDto(
    val historyStatus: List<TypeStatusList>
)

fun ReferenceHistoryDtoItem.toReferenceHistoryModel(): TypeStatusList {
    return TypeStatusList(
        CountOrder = this.CountOrder,
        Date = this.Date,
        NumberOrder = this.NumberOrder,
        Status = this.Status,
        TypeOrder = this.TypeOrder
    )
}
