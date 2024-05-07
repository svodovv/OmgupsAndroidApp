package com.example.omgupsandroidapp.domain.repository

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.omgupsapp.common.Resource

interface ServiceRepository {
    suspend fun getScholarship(): ScholarshipDto

    suspend fun postSpravka(post: SpravkaPostModel): Resource<SpravkaPostModel>

    suspend fun getOrder(): OrderDto

    suspend fun getTypesSravki(): TypeSpravkaDto
}