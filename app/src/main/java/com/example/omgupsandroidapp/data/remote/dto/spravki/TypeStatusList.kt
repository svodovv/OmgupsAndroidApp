package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.google.gson.annotations.SerializedName

data class TypeStatusList(
    @SerializedName("CountOrder")
    val CountOrder: String,
    @SerializedName("Date")
    val Date: String,
    @SerializedName("NumberOrder")
    val NumberOrder: String,
    @SerializedName("Status")
    val Status: String,
    @SerializedName("TypeOrder")
    val TypeOrder: String
)