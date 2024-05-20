package com.example.omgupsandroidapp.data.remote.dto.spravki

import android.util.Log
import com.example.omgupsandroidapp.domain.model.service.SpravkiModel
import com.google.gson.annotations.SerializedName

data class TypeList(
    val ID: String,
    val Value: String
)
data class TypeSpravkaDto(
   // @SerializedName("OrderStatus")
    val TypeList: List<TypeList>,
)

fun TypesSpravkiDtoItem.toTypesSpravkiModel(): TypeList {
    return TypeList(
        ID = this.ID,
        Value = this.Value,
    )
}