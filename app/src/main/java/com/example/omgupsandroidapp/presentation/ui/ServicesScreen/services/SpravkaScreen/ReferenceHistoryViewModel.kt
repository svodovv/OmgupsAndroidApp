package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetReferenceHistoryUseCase
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetTypesSpravkiUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import java.net.IDN
import javax.inject.Inject

@HiltViewModel
class ReferenceHistoryViewModel @Inject constructor(
    private val getReferenceHistoryUseCase: GetReferenceHistoryUseCase
): ViewModel() {

    val _referenceHistoryState = MutableStateFlow(ReferenceHistoryState())
    val referenceHistoryState = _referenceHistoryState.asStateFlow()

    init {
        runBlocking {
            getReferenceHistory(1)
            getReferenceHistory(2)
        }
    }

    suspend fun getReferenceHistory(id: Int) : List<TypeStatusList> {
        getReferenceHistoryUseCase.invoke(id).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _referenceHistoryState.update {
                       // result.data?.historyStatus?.let { it1 -> it.copy(referenceHistoryList = it1) }!!
                        when (id){
                            1 -> it.copy(referenceHistoryList0 = result.data?.historyStatus ?: emptyList())
                            else -> it.copy(referenceHistoryList1 = result.data?.historyStatus ?: emptyList())
                        }
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
        }.launchIn(viewModelScope)
        return referenceHistoryState.value.referenceHistoryList0.plus(referenceHistoryState.value.referenceHistoryList1)
    }
  /*  suspend fun getType(){
        getTypesSpravkiUseCase.invoke().collect {
            type.value.spravkiList[0].ID
        }
    }*/
}