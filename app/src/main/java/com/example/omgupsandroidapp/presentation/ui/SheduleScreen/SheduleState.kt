package com.example.omgupsandroidapp.presentation.ui.SheduleScreen

import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.domain.model.service.SheduleModel

data class SheduleState(
    val sheduleList: List<SheduleModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)