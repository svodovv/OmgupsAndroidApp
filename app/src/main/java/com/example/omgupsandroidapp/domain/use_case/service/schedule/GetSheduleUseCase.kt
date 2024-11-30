package com.example.omgupsandroidapp.domain.use_case.service.schedule

import android.util.Log
import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleSaveRepository
import com.example.omgupsandroidapp.data.local.Room.Cache.mapToRemote
import com.example.omgupsandroidapp.data.remote.dto.schedule.toSheduleModel
import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl
import com.example.omgupsandroidapp.data.schedule.ScheduleRepository
import com.omgupsapp.common.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSheduleUseCase @Inject constructor(
    private val serviceRepositoryImpl: ServiceRepositoryImpl,
    private val scheduleSaveRepository: ScheduleSaveRepository,
    private val scheduleRepository: ScheduleRepository
) {

    /*operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val scheduleList = scheduleSaveRepository.saveFromResponse().map {
                it
            }
            emit(Resource.Success(scheduleList))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScheduleUseCase", "IO Exception $e")
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScheduleUseCase", "HTTP Exception $e")
    }
    }*/

    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val scheduleList = scheduleRepository.fetchSchedule().map {
                it.mapToRemote()
            }
            //val save = scheduleSaveRepository.saveFromResponse()
            emit(Resource.Success(scheduleList))
            //emit(Resource.Success(save))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScholarshipUseCase", "IO Exception $e")
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScholarshipUseCase", "HTTP Exception $e")
        }
    }
}