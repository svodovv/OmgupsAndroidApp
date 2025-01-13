package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen


data class LoadSpravkaState(
    //val spravkaForm: Response<LoadSpravkaDto>?,
    //val spravkaForm: List<LoadSpravka> = emptyList(),
    val stasusAfterOrder: String = "",
    val isLoading: Boolean = false,
    val error: String = ""
)