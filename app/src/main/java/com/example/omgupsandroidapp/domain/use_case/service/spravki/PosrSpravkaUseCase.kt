package com.example.omgupsandroidapp.domain.use_case.service.spravki

import android.util.Log
import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.omgupsapp.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostSpravkaUseCase @Inject constructor(
    private val serviceRepositoryImpl: ServiceRepositoryImpl
) {
    operator fun invoke(spravka: SpravkaPostModel) = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(spravka))
        }
        catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScholarshipUseCase", "IO Exception $e")
        }
        catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScholarshipUseCase", "HTTP Exception $e")
        }
    }


}