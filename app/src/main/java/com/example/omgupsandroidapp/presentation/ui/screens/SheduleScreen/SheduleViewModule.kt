package com.example.omgupsandroidapp.presentation.ui.screens.SheduleScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.service.shedule.GetSheduleUseCase
import com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.OrderScreen.OrderState
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
@HiltViewModel
class SheduleViewModul @Inject constructor(
    private val getSheduleUseCase: GetSheduleUseCase
): ViewModel() {

    private val _sheduleState = MutableStateFlow(SheduleState())
    val sheduleState = _sheduleState.asStateFlow()

    init {
          getShedule()
    }

      fun getShedule(){
        getSheduleUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _sheduleState.update {
                        it.copy(sheduleList = result.data ?: emptyList())
                    }
                }

                is Resource.Loading -> {
                    _sheduleState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Error -> {
                    _sheduleState.update {
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