package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen

import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.AcademicPlanDtoItemModel


data class AcademicPlanState(
    val AcademicPlanList: List<AcademicPlanDtoItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)