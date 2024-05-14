package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.example.omgupsandroidapp.domain.use_case.service.spravki.PostSpravkaUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import retrofit2.Call
import javax.inject.Inject
@HiltViewModel
class OrderSpravkaViewModel @Inject constructor(
   private val postSpravkaUseCase: PostSpravkaUseCase
    //private val serviceApi: ServiceApi
): ViewModel() {


    var _orderSpravka = MutableStateFlow(LoadSpravkaState())
    var orderSpravka = _orderSpravka.asStateFlow()
    var myresponse: MutableLiveData<retrofit2.Response<SpravkaPostModel>?> = MutableLiveData()


       fun postSravka(postSpravkA: LoadSpravka): String {
            viewModelScope.launch {
                postSpravkaUseCase.invoke(postSpravkA).catch {
                    _orderSpravka.update {
                        it.copy(
                            error = "Ошибка соединения"
                                ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                        )
                    }
                }.collect{result ->
                    when(result) {
                        is Resource.Success -> {
                            _orderSpravka.update {
                               // it.copy(spravkaForm = result.data?.spravkaForm ?: emptyList())
                                it.copy(stasusAfterOrder = orderSpravka.value.stasusAfterOrder )
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
                }
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
           return orderSpravka.value.stasusAfterOrder
    }

    /*suspend fun postSravka(post: SpravkaPostModel){
        viewModelScope.launch {
            val response = serviceApi.postSpravka(post)
            myresponse.value = response
        }
    }*/
}