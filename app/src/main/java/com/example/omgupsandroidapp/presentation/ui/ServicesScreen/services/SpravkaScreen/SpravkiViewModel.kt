package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.example.omgupsandroidapp.domain.use_case.service.order.GetOrderUseCase
import com.example.omgupsandroidapp.domain.use_case.service.scholarship.GetScholarshipUseCase
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetTypesSpravkiUseCase
import com.example.omgupsandroidapp.domain.use_case.service.spravki.PostSpravkaUseCase
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen.ScholarshipState
import com.google.gson.internal.bind.TypeAdapters.URL
import com.omgupsapp.common.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Response
import java.net.URL
import javax.inject.Inject


@HiltViewModel
class SpravkiViewModel @Inject constructor(
    private val getTypesSpravkiUseCase: GetTypesSpravkiUseCase
): ViewModel() {

    val _spravkiState = MutableStateFlow(SpravkiState())
    val spravkiState = _spravkiState.asStateFlow()
    //var myResponse: MutableLiveData<Response<SpravkaPostModel>> = MutableLiveData()
    init {
        getSpravkiTypes()
    }

     fun getSpravkiTypes(){
        getTypesSpravkiUseCase.invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _spravkiState.update {
                        it.copy(spravkiList = result.data?.TypeList ?: emptyList())
                    }
                }

                is Resource.Loading -> {
                    _spravkiState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Error -> {
                    _spravkiState.update {
                        it.copy(
                            error = result.message
                                ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    /*fun postSpravka(post: SpravkaPostModel) {
        viewModelScope.launch {
            val response = repository.postSpravka(post)
            myResponse.value = response
        }
    }*/
     /*fun postSpravka(post: SpravkaPostModel) {
        viewModelScope.launch {
            val resource = repository.postSpravka(post)
            if (resource is Resource.Success) {
                val response = Response.success(resource.data)
                myResponse.value = response
            } else if (resource is Resource.Error) {
                // Обработка ошибки, если необходимо
            }
        }
    }*/
            /* val client = OkHttpClient()
             val url = URL("student/loadspravka")

             var jsonString = "{\"id\": \"1\", \"current\": \"2\"}"

             val mapperAll = ObjectMapper()
             val jacksonObj = mapperAll.createObjectNode()*/


            /*fun onButtonClicked(spravka: SpravkiState) {
       viewModelScope.launch {
       }
   }*/


            /* private fun postSpravka(){
        spravkiUseCase.invoke().onEach {  }/*{   result ->
            when (result){
                is Resource.Loading -> {
                    _spravki.update {
                        it.copy(
                            loading = true
                        )
                    }
                }

                is Resource.Error -> {
                    _spravki.update {
                        it.copy(
                            error = it.error
                        )
                    }
                }

                is Resource.Success -> TODO()
            }
        }*/
    }*/

}