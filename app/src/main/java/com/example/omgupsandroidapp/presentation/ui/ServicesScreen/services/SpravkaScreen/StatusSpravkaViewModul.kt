package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetStatusSpravkaUseCase
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
class StatusSpravkaViewModul @Inject constructor(
    private val getStatusSpravkaUseCase: GetStatusSpravkaUseCase
) : ViewModel() {


    private val _status = MutableStateFlow(StatusState())
    val status = _status.asStateFlow()


    init {
        runBlocking {
            getStatus(1)
            getStatus(2)
        }
    }
    suspend fun getStatus(id: Int): String {
       getStatusSpravkaUseCase.invoke(id).onEach { result ->
           when(result) {
               is Resource.Success -> {
                   _status.update {
                       when (id) {
                           1 -> it.copy(spravkiStatus0 = (result.data?.responseStatus ?: String).toString())
                           else -> it.copy(spravkiStatus1 = (result.data?.responseStatus ?: String).toString())
                       }
                   }
               }
               is Resource.Loading -> {
                   _status.update {
                       it.copy(isLoading = true)
                   }
               }

               is Resource.Error -> {
                   _status.update {
                       it.copy(
                           error = result.message
                               ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                       )
                   }
               }
           }
       }.launchIn(viewModelScope)
         return status.value.spravkiStatus0.plus(status.value.spravkiStatus1)
    }
}