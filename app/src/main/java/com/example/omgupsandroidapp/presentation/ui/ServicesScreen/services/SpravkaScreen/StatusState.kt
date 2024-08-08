package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeList

data class StatusState(
    val spravkiStatus0: String = " ",
    val spravkiStatus1: String = " ",
    val isLoading: Boolean = false,
    val error: String = ""
)