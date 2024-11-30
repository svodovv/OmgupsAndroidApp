package com.example.omgupsandroidapp.data.remote.dto.acafemicplan

import com.example.omgupsandroidapp.domain.model.service.AcademicPlanModel

data class AcademicPlanDtoItem(
    val IsControl: String?,
    val amount: String?,
    val code: String?,
    val load: String?,
    val name: String?,
    val period: String?,
    val unit: String?
)

fun AcademicPlanDtoItem.toAcademicPlanModel(): AcademicPlanModel {
    return AcademicPlanModel(
        IsControl =  IsControl ?: "",
        amount = amount ?: "",
        code = code ?: "",
        load = load ?: "",
        name = name ?: "",
        period = period ?: "",
        unit = unit ?: ""
    )
}