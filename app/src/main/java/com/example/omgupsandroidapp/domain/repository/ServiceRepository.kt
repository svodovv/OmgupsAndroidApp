package com.example.omgupsandroidapp.domain.repository

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.omgupsapp.common.Resource
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

interface ServiceRepository {
    suspend fun getScholarship(): ScholarshipDto

    suspend fun postSpravka(post: LoadSpravka): LoadSpravkaDto

    suspend fun getOrder(): OrderDto

    suspend fun getTypesSravki(): TypeSpravkaDto

    suspend fun getReferenceHistory(id: Int): ReferenceHistoryDto

    suspend fun getStatusSpravka(id: Int): StatusSpravakaDto

    suspend fun getShudele(): SheduleDto
}