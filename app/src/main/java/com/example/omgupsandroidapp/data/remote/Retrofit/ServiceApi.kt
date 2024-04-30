package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import retrofit2.http.GET

interface ServiceApi {

    @GET("student/getstipend")
    suspend fun getScholarship(): ScholarshipDto
}