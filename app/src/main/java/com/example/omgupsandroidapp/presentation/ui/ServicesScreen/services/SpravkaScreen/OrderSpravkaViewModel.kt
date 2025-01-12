 package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.domain.use_case.service.spravki.PostSpravkaUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class OrderSpravkaViewModel @Inject constructor(
   private val postSpravkaUseCase: PostSpravkaUseCase

): ViewModel() {

    var _orderSpravka = MutableStateFlow(LoadSpravkaState("Ожидаем результат"))
    var orderSpravka = _orderSpravka.asStateFlow()
       /*fun postSravka(postSpravkA: LoadSpravka): String {
            viewModelScope.launch {
                postSpravkaUseCase.invoke(postSpravkA).catch {
                    _orderSpravka.update {
                        it.copy(
                            error = "Ошибка соединения"
                                ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                        )
                    }
                }.onEach{result ->
                    when(result) {
                        is Resource.Success -> {
                            _orderSpravka.update {
                               // it.copy(spravkaForm = result.data?.spravkaForm ?: emptyList())
                                //it.copy(stasusAfterOrder = orderSpravka.value.stasusAfterOrder )
                                it.copy( stasusAfterOrder = (result.data?.status.toString()))
                            }
                        }
                        is Resource.Loading -> {
                            _orderSpravka.update {
                                it.copy(isLoading = true)
                            }
                        }
                        is Resource.Error -> {
                            _orderSpravka.update {
                                it.copy(
                                    error = result.message
                                        ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                                )
                            }
                        }
                    }
                }.launchIn(viewModelScope)
            }
           /* when(result) {
                is Resource.Success -> {
                    _orderSpravka.update {
                        it.copy(spravkaForm = result.data?.body()?.spravkaForm ?: emptyList())
                    }
                }
                is Resource.Loading -> {
                    _orderSpravka.update {
                        it.copy(isLoading = true)
                    }
                }
                is Resource.Error -> {
                    _orderSpravka.update {
                        it.copy(
                            error = result.message
                                ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                        )
                    }
                }
            }*/
           return _orderSpravka.value.stasusAfterOrder
    }*/
       suspend fun postSravka(postSpravka: LoadSpravka): String {
           var statusResult = ""

           // Используем try-catch для обработки ошибок
           try {
               // Дожидаемся результата выполнения запроса
               postSpravkaUseCase.invoke(postSpravka).catch {
                   _orderSpravka.update {
                       it.copy(
                           error = "Ошибка соединения"

                       )
                   }
               }.collect { result ->
                   when (result) {
                       is Resource.Success -> {
                           _orderSpravka.update {

                               statusResult = result.data?.status.toString() // Сохраняем результат
                               it.copy(stasusAfterOrder = statusResult, isLoading = false)
                           }
                       }
                       is Resource.Loading -> {
                           _orderSpravka.update {
                               it.copy(isLoading = true)
                           }
                       }
                       is Resource.Error -> {
                           _orderSpravka.update {
                               it.copy(
                                   isLoading = false,
                                   error = result.message
                                       ?: "Ошибка соединения, это может быть вызвано активным VPN сервисом"
                               )
                           }
                       }
                   }
               }
           } catch (e: Exception) {
               _orderSpravka.update {
                   it.copy(
                       isLoading = false,
                       error = e.localizedMessage ?: "Неизвестная ошибка"
                   )
               }
           }

           return statusResult // Возвращаем результат после завершения
       }


    /*fun postSravka(postSpravka: LoadSpravka): String {
           //var statusResult = ""
        viewModelScope.async {
            postSpravkaUseCase.invoke(postSpravka).catch {
                _orderSpravka.update {
                    it.copy(
                        error = "Ошибка соединения"
                            ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                    )
                }
            }.onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _orderSpravka.update {
                            Log.i("StatusAfterOrderSpravka","РАНЬШЕ SUCCESS")
                               it.copy(stasusAfterOrder = (result.data?.status.toString()), isLoading = false)

                        }
                        //statusResult = result.data?.status.toString() // Сохраняем результат
                    }
                    is Resource.Loading -> {
                        _orderSpravka.update {
                            it.copy(isLoading = true)
                        }
                    }
                    is Resource.Error -> {
                        _orderSpravka.update {
                            it.copy( isLoading = false,
                                error = result.message
                                    ?: "Ошибка соединения, это может быть вызвано активным VPN сервисом"
                            )
                        }
                    }
                }
            }.launchIn(viewModelScope)
        }

        return  _orderSpravka.value.stasusAfterOrder
    }*/

}