package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.GradeBook

import com.example.omgupsandroidapp.data.remote.dto.gradeBook.ListGradeDtoItem

data class GradeBookState(
    val gradeBookList: List<ListGradeDtoItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)