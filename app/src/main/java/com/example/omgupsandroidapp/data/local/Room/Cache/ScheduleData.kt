package com.example.omgupsandroidapp.data.local.Room.Cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.domain.model.service.SheduleModel


@Entity(tableName = "schedule")
data class ScheduleEntity(
    val day_of_week: String,
    //val guid: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val sgroup: String,
    val subj: String,
    val time: Int,
    val type_of_week: Int
)

fun ScheduleEntity.mapToRemote(): SheduleModel {
    return SheduleModel(
        day_of_week = this.day_of_week,
      //  guid = this.guid,
        id = this.id,
        sgroup = this.sgroup,
        subj = this.subj,
        time = this.time,
        type_of_week = this.type_of_week
    )
}

