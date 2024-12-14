package com.example.omgupsandroidapp.data.remote.dto.schedule

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.omgupsandroidapp.domain.model.service.SheduleModel


open class SheduleDto : ArrayList<ShedelItem>()

@Entity(tableName = "schedule")
data class ShedelItem(
    val day_of_week: String,
   // val guid: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val sgroup: String,
    val subj: String,
    val time: Int,
    val type_of_week: Int
)

fun ShedelItem.toSheduleModel(): SheduleModel {
    return SheduleModel(
        day_of_week = day_of_week,
      //  guid = guid,
        id = id,
        sgroup = sgroup,
        subj = subj,
        time = time,
        type_of_week = type_of_week
    )
}
