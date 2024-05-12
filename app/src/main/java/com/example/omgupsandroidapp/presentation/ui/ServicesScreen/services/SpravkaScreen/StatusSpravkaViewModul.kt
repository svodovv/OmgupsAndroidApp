package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import androidx.lifecycle.ViewModel
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetStatusSpravkaUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
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
        runBlocking { getStatus(0)}
        runBlocking { getStatus(1)}
    }
     suspend fun getStatus(id: Int): String {
       getStatusSpravkaUseCase.invoke(id).collectLatest { result ->
           when(result) {
               is Resource.Success -> {
                   _status.update {
                       it.copy(spravkiStatus = (result.data?.responseStatus?: String).toString())
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

       }
         return status.value.spravkiStatus
    }
}