package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList

data class ReferenceHistoryState (
    val referenceHistoryList0: List<TypeStatusList> = emptyList(),
    val referenceHistoryList1: List<TypeStatusList> =emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)