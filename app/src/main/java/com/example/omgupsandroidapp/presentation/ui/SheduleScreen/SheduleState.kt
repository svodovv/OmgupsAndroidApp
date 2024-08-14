package com.example.omgupsandroidapp.presentation.ui.SheduleScreen

import com.example.omgupsandroidapp.domain.model.service.SheduleModel

data class SheduleState(
    val sheduleList: List<SheduleModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)