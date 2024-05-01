package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen

import com.example.omgupsandroidapp.domain.model.ScholarshipModel

data class ScholarshipState(
    val scholarshipList: List<ScholarshipModel> = emptyList(),
    val totalSum: Int? = null,
    val loading: Boolean = false,
    val error: String = ""
)
