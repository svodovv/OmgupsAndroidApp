package com.example.omgupsandroidapp.data.repository

import com.example.omgupsandroidapp.data.local.Room.Cache.DataScheduleDao
import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.AcademicPlanDto
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.AcademicPlanDtoItem
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.SpravkaResponse
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList

import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.toDtoLoadSpravka
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.example.omgupsandroidapp.domain.repository.ServiceRepository
import com.omgupsapp.common.Resource
import com.omgupsapp.data.local.Room.AppDatabase
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class ServiceRepositoryImpl @Inject constructor(
      private val serviceApi: ServiceApi,
      //private val dataScheduleDao: AppDatabase
) : ServiceRepository {

    override suspend fun getScholarship(): ScholarshipDto {
        return serviceApi.getScholarship()
    }
    /*override suspend fun postSpravka(csrfToken: String,type : Int, count : Int): Resource<SpravkaPostModel> {
        return serviceApi.postSpravka(csrfToken,type,count)
    }*/
    /*override suspend fun postSpravka(post: LoadSpravka): Response<LoadSpravkaDto> {
        return serviceApi.postSpravka(post.toDtoLoadSpravka())
    }*/

    override suspend fun postSpravka(post: LoadSpravkaDto): SpravkaResponse {
        return serviceApi.postSpravka(post.toDtoLoadSpravka())
    }

    override suspend fun getOrder(): OrderDto{
        return serviceApi.getOrders()
    }

    override suspend fun getTypesSravki(): TypeSpravkaDto {
        return serviceApi.getTypesSpravki()
    }

    override suspend fun getReferenceHistory(id: Int): ReferenceHistoryDto {
        return serviceApi.getReferenceHistory(id)
    }

    override suspend fun getStatusSpravka(id: Int): StatusSpravakaDto {
        return serviceApi.getStatysSpravka(id)
    }

    override suspend fun getShudele(): List<ScheduleEntity> {
        return serviceApi.getShudule()
    }

    override suspend fun getAcademicPlan(): AcademicPlanDto {
        return serviceApi.getAcademicPlan()
    }

    /*private val scheduleDao = dataScheduleDao.dataSchedule()

    override suspend fun saveSchedule(schedule: SheduleDto) {
        scheduleDao.deleteAllSchedule()
        schedule.map {
            scheduleDao.insertSchedule(
                ScheduleEntity(
                    day_of_week = it.day_of_week,
                    guid = it.guid,
                    sgroup = it.sgroup,
                    id = it.id,
                    subj = it.subj,
                    time = it.time,
                    type_of_week = it.type_of_week
                )
            )
        }
    }*/
}