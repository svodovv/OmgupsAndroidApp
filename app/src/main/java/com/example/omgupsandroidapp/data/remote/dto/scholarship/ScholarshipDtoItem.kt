package com.example.omgupsandroidapp.data.remote.dto.scholarship

import com.example.omgupsandroidapp.domain.model.service.ScholarshipModel
import com.google.gson.annotations.SerializedName

data class ScholarshipDtoItem(
    val date: String,
    @SerializedName("date_interval")
    val dateInterval: String,
    val sum: String,
    @SerializedName("type_of_order")
    val typeOfOrder: String,
    @SerializedName("type_of_payment")
    val typeOfPayment: String,
    val year: String
)

fun ScholarshipDtoItem.toScholarshipModel(): ScholarshipModel {
    return ScholarshipModel(
        dateInterval = dateInterval,
        sum = sum,
        typeOfPayment = typeOfPayment,
        year = year
    )
}