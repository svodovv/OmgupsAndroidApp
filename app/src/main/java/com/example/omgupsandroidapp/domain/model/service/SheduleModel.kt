package com.example.omgupsandroidapp.domain.model.service

import com.google.gson.annotations.SerializedName

data class SheduleModel (
    @SerializedName("day_of_week")
    var day_of_week: String,
    @SerializedName("guid")
    val guid: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("sgroup")
    val sgroup: String,
    @SerializedName("subj")
    val subj: String,
    @SerializedName("time")
    val time: Int,
    @SerializedName("type_of_week")
    val type_of_week: Int
)