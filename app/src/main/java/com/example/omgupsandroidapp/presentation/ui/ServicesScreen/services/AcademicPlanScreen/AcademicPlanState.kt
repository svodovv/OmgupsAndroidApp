package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen

import com.example.omgupsandroidapp.domain.model.service.AcademicPlanModel


data class AcademicPlanState(
    val AcademicPlanList: List<AcademicPlanModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)