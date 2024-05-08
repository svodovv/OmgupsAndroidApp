package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDtoItem



data class TypesSpravkiDtoItem(
    val ID: String,
    val Value: String,
)

data class ReferenceHistoryDtoItem (
    val CountOrder: String,
    val Date: String,
    val NumberOrder: String,
    val Status: String,
    val TypeOrder: String
)