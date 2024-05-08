package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import com.example.omgupsandroidapp.data.remote.dto.spravki.OrderStatusDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDtoItem
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeList

data class ReferenceHistoryState (
    val referenceHistoryList: List<OrderStatusDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)