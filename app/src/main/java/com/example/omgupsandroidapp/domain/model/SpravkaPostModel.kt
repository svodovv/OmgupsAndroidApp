package com.example.omgupsandroidapp.domain.model

import androidx.lifecycle.ViewModel

data class SpravkaPostModel(
    val type : Int,
    val current : Int,
    val csrfToken: String
)
