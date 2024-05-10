package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.example.omgupsandroidapp.domain.repository.ServiceRepository
import com.example.omgupsandroidapp.domain.use_case.service.spravki.GetReferenceHistoryUseCase
import com.example.omgupsandroidapp.domain.use_case.service.spravki.PostSpravkaUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.Response
import retrofit2.http.POST
import javax.inject.Inject
@HiltViewModel
class OrderSpravkaViewModel @Inject constructor(
   private val postSpravkaUseCase: PostSpravkaUseCase
    //private val serviceApi: ServiceApi
): ViewModel() {


    val post = SpravkaPostModel(0,1)
    var _orderSpravka = MutableStateFlow(SpravkaPostModel())
    var orderSpravka = _orderSpravka.asStateFlow()
    var myresponse: MutableLiveData<retrofit2.Response<SpravkaPostModel>?> = MutableLiveData()

    /*init {
         postSravka(post)
    }*/

    suspend fun postSravka(){
        postSpravkaUseCase.invoke().collectLatest { result ->
            when(result) {
                is Resource.Success {
                    _orderSpravka.update {
                        it.copy( = result.data?.)
                    }
                }
            }
        }
    }

    /*suspend fun postSravka(post: SpravkaPostModel){
        viewModelScope.launch {
            val response = serviceApi.postSpravka(post)
            myresponse.value = response
        }
    }*/
}