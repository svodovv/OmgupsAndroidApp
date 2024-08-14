package com.example.omgupsandroidapp.data.remote.dto.schedule

import com.example.omgupsandroidapp.domain.model.service.SheduleModel


class SheduleDto : ArrayList<ShedelItem>()
data class ShedelItem(
    val day_of_week: String,
    val guid: String,
    val id: Int,
    val sgroup: String,
    val subj: String,
    val time: Int,
    val type_of_week: Int
)

fun ShedelItem.toSheduleModel(): SheduleModel {
    return SheduleModel(
        day_of_week = day_of_week,
        guid = guid,
        id = id,
        sgroup =sgroup,
        subj = subj,
        time = time,
        type_of_week = type_of_week
    )
}