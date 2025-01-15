package com.example.omgupsandroidapp.presentation.ui.SheduleScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleSaveRepository
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.schedule.ScheduleRepository
import com.example.omgupsandroidapp.domain.use_case.service.schedule.GetSheduleUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import javax.inject.Inject

@HiltViewModel
class SheduleViewModul @Inject constructor(
    private val getSheduleUseCase: GetSheduleUseCase,
    private val dataScheduleRepo: ScheduleSaveRepository
): ViewModel() {

    private val _sheduleState = MutableStateFlow(SheduleState())

     val sheduleState = _sheduleState.asStateFlow()
   /* private val _sheduleState = MutableStateFlow<List<ShedelItem>>(emptyList())
    val sheduleState = _sheduleState.asStateFlow()
    //val dbSchedule = dataScheduleRepo.saveFromResponse().asLiveData()
    init {
        viewModelScope.launch {
            getSheduleUseCase.invoke().collect { it ->
                sheduleState.value = it

            }
        }
        getShedule()
    }*/

   /* fun getShedule() {
        getSheduleUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val data = result.data?.firstOrNull()?.let { list ->
                        list
                    } ?: emptyList()
                    _sheduleState.update {
                        it.copy(sheduleList = data)
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
    }*/

    fun getShedule(){
            getSheduleUseCase.invoke().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _sheduleState.update {
                            it.copy(sheduleList = result.data ?: emptyList())
                            //it.copy(isLoading = false)
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