package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.service.academicPlan.AcademicPlanUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AcademicPlanViewModel @Inject constructor(
    private val getAcademicPlanUseCase: AcademicPlanUseCase
): ViewModel()  {

    private val _academicPlanState = MutableStateFlow(AcademicPlanState())
    val academicPlanState = _academicPlanState.asStateFlow()

    init {
        getAcademicPlan()
    }

    private fun getAcademicPlan(){
        getAcademicPlanUseCase.invoke().onEach {result ->
            when (result) {
                is Resource.Success -> {
                    _academicPlanState.update {
                        it.copy(AcademicPlanList = result.data ?: emptyList())
                    }
                }

                is Resource.Loading -> {
                    _academicPlanState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Error -> {
                    _academicPlanState.update {
                        it.copy(
                            error = result.message
                                ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                        )
                    }
                }

            }
        }.launchIn(viewModelScope)
    }

}