package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeList

data class OrderSpravkaState(
    val spravkiList: List<TypeList> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)