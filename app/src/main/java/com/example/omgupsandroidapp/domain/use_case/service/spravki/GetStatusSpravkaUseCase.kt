package com.example.omgupsandroidapp.domain.use_case.service.spravki

import android.annotation.SuppressLint
import android.util.Log
import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl
import com.omgupsapp.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStatusSpravkaUseCase @Inject constructor(
    private val serviceRepositoryImpl: ServiceRepositoryImpl
) {
    @SuppressLint("SuspiciousIndentation")
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val statysSpravka = serviceRepositoryImpl.getStatusSpravka()
            emit(Resource.Success(statysSpravka))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScholarshipUseCase", "IO Exception $e")
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScholarshipUseCase", "HTTP Exception $e")
        }
    }
}