package com.example.omgupsandroidapp.domain.model.service

data class SheduleModel (
    val day_of_week: String,
    val guid: String,
    val id: Int,
    val sgroup: String,
    val subj: String,
    val time: Int,
    val type_of_week: Int
)