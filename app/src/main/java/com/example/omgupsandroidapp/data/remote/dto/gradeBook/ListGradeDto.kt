package com.example.omgupsandroidapp.data.remote.dto.gradeBook

data class ListGradeDtoItem(
    val avGrage: Double,
    val debt: Int,
    val form: String,
    val grades: List<Grade>
)