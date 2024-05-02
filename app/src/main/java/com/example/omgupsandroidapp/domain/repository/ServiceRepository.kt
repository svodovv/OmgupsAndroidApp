package com.example.omgupsandroidapp.domain.repository

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto

interface ServiceRepository {
    suspend fun getScholarship(): ScholarshipDto
    suspend fun getOrder(): OrderDto
}