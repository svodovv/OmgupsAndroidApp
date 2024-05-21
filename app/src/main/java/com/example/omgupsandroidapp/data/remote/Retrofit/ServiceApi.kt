package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.SheduleDto
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import retrofit2.http.GET

interface ServiceApi {

    @GET("student/getstipend")
    suspend fun getScholarship(): ScholarshipDto

    @GET("student/getorders")
    suspend fun getOrders(): OrderDto

    @GET("student/getschedule")
    suspend fun getShudule(): SheduleDto

}