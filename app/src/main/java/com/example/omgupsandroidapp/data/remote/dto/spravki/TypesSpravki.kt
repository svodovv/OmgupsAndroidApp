package com.example.omgupsandroidapp.data.remote.dto.spravki

import android.util.Log
import com.example.omgupsandroidapp.domain.model.service.SpravkiModel

data class TypeSpravkaDto(
    val TypeList: List<TypeList>,
)

fun TypesSpravkiDtoItem.toTypesSpravkiModel(): TypeList {
    return TypeList(
        ID = this.ID,
        Value = this.Value,
    )
}