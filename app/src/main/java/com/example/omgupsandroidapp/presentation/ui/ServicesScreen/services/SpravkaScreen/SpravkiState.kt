package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeList
import com.example.omgupsandroidapp.domain.model.service.OrderModel
import com.example.omgupsandroidapp.domain.model.service.SpravkiModel
import java.lang.reflect.Type

data class SpravkiState(
    val spravkiList: List<TypeList> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
    )