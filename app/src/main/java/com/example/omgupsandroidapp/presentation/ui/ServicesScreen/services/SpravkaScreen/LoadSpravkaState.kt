package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen


import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.google.gson.annotations.SerializedName

data class LoadSpravkaState(
    //val spravkaForm: Response<LoadSpravkaDto>?,
    //val spravkaForm: List<LoadSpravka> = emptyList(),
    val stasusAfterOrder: String = " ",
    val isLoading: Boolean = false,
    val error: String = ""
)