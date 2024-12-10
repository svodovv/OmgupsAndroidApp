package com.example.omgupsandroidapp.data.remote.dto.acafemicplan

import com.example.omgupsandroidapp.domain.model.service.AcademicPlanModel

data class AcademicPlanDtoItemDiscipline(
    val IsControl: Boolean?,
    val amount: String?,
    val code: String?,
    val load: String?,
    var name: String?,
    val period: String?,
    val unit: String?
)

fun AcademicPlanDtoItemDiscipline.toAcademicPlanModel(): AcademicPlanModel {
    return AcademicPlanModel(
        IsControl =  IsControl ?: false,
        amount = amount ?: "",
        code = code ?: "",
        load = load ?: "",
        name = name ?: "",
        period = period ?: "",
        unit = unit
            ?: ""
    )
}

data class Discipline(
    val IsControl: Boolean?,
    val amount: String?,
    val code: String?,
    val load: String?,
    val period: String?,
    val unit: String?
)