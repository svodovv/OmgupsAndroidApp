package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import androidx.lifecycle.ViewModel
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetReferenceHistoryUseCase
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetTypesSpravkiUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ReferenceHistoryViewModel @Inject constructor(
    private val getReferenceHistoryUseCase: GetReferenceHistoryUseCase
): ViewModel() {

    val _referenceHistoryState = MutableStateFlow(ReferenceHistoryState())
    val referenceHistoryState = _referenceHistoryState.asStateFlow()



    fun getReferenceHistory(){
        getReferenceHistoryUseCase.invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _referenceHistoryState.update {
                        it.copy(referenceHistoryList = result.data? ?: emptyList())
                    }
                }

                is Resource.Loading -> {
                    _referenceHistoryState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Error -> {
                    _referenceHistoryState.update {
                        it.copy(
                            error = result.message
                                ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                        )
                    }
                }
            }
        }
    }
}