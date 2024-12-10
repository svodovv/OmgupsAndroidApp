package com.example.omgupsandroidapp.data.remote.dto.acafemicplan

import com.example.omgupsandroidapp.domain.model.service.AcademicPlanModel

class AcademicPlanDto : ArrayList<AcademicPlanDtoItem>()

data class AcademicPlanDtoItem(
    //val disciplines: List<AcademicPlanDtoItemDiscipline>,
    val disciplines: Map<String, Array<AcademicPlanDtoItemDiscipline>>,
    val id: String,
    val name: String
)

data class AcademicPlanDtoItemModel(
    val disciplines: Map<String, Array<AcademicPlanDtoItemDiscipline>>,//val disciplines: List<AcademicPlanDtoItemDiscipline>,
    val id: String,
    val name: String
)

fun AcademicPlanDtoItem.toAcademicPlanDtoItem(): AcademicPlanDtoItemModel {
    return AcademicPlanDtoItemModel(
        disciplines = disciplines,
        id = id,
        name = name
    )
}