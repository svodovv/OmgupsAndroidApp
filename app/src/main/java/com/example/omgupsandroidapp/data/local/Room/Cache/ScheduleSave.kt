package com.example.omgupsandroidapp.data.local.Room.Cache

import androidx.room.withTransaction
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto
import com.example.omgupsandroidapp.domain.model.service.SheduleModel
import com.example.omgupsandroidapp.presentation.utils.networkBoundResource
import com.omgupsapp.data.local.Room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScheduleSaveRepository @Inject constructor(
    val serviceApi: ServiceApi,
    val dataSchedule : AppDatabase
): SheduleDto() {

    /*private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun saveFromResponse(scheduleFull: SheduleDto) = networkBoundResource {
        coroutineScope.launch {
            scheduleFull.map {
                dataSchedule.insertSchedule(
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
        }
    }*/
    private val dataDao = dataSchedule.dataScheduleDao()

     /*fun saveFromResponse() = networkBoundResource(
        query = {
            dataDao.getScheduleFromHost()
        },
        fetch = {
            delay(2000)
            serviceApi.getShudule()
        },
        saveFetchResult = { data ->
            dataSchedule.withTransaction {
                dataDao.deleteAllSchedule()
                data.map {
                    dataDao.insertSchedule(it)
                }
            }

        }
    )*/
}