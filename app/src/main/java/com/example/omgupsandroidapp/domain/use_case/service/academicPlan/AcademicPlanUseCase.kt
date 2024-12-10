package com.example.omgupsandroidapp.domain.use_case.service.academicPlan

import android.util.Log
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.toAcademicPlanDtoItem
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.toAcademicPlanModel
import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl
import com.omgupsapp.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AcademicPlanUseCase @Inject constructor(
    private val serviceRepositoryImpl: ServiceRepositoryImpl
) {
    operator fun invoke() = flow {
        try{
            emit(Resource.Loading())
            val academicPlanListAll = serviceRepositoryImpl.getAcademicPlan().map {
                it.toAcademicPlanDtoItem()
            }
            emit(Resource.Success(academicPlanListAll))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScholarshipUseCase", "IO Exception $e")
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScholarshipUseCase", "HTTP Exception $e")
        }
    }
}