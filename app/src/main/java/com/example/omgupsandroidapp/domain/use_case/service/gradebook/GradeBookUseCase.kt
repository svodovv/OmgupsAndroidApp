package com.example.omgupsandroidapp.domain.use_case.service.gradebook

import android.util.Log
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.toAcademicPlanDtoItem
import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl
import com.omgupsapp.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GradeBookUseCase @Inject constructor(
    private val serviceRepositoryImpl: ServiceRepositoryImpl
) {
    operator fun invoke() = flow {
        try{
            emit(Resource.Loading())
            val gradeBooks = serviceRepositoryImpl.getGradeBook().name.map { it }
                emit(Resource.Success(gradeBooks))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GradeBookUseCase", "IO Exception $e")
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GradeBookUseCase", "HTTP Exception $e")
        }
    }
}