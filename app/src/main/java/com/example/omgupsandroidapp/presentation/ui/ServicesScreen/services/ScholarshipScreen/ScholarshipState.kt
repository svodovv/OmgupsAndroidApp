package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen

import com.example.omgupsandroidapp.domain.model.service.Scholarship.ScholarshipModel
import com.example.omgupsandroidapp.domain.model.service.Scholarship.TotalSumPerMonthModel

data class ScholarshipState(
    val scholarshipList: List<ScholarshipModel> = emptyList(),
    val totalSum: TotalSumPerMonthModel? = null,
    val loading: Boolean = false,
    val error: String = ""
)
