package com.example.omgupsandroidapp.presentation.ui.ServicesScreen

import androidx.lifecycle.ViewModel
import com.example.omgupsandroidapp.R
import com.omgupsapp.presentation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ServicesViewModel @Inject constructor() : ViewModel() {

    val serviceList = listOf(
        Service(
            "Выплаты", Screen.MoneyScreen.route, R.drawable.ic_modey
        ),
        Service(
            "Приказы", Screen.OrderScreen.route, R.drawable.ic_order
        ),
        Service(
            "Учебный план", Screen.PlanScreen.route, R.drawable.ic_plan
        ),
        Service(
            "Зачетная книжка", Screen.StudentBookScreen.route, R.drawable.ic_study_card
        ),
        Service(
            "Заказ справок", Screen.SpravkaScreen.route, R.drawable.ic_spravki
        )
    )
}