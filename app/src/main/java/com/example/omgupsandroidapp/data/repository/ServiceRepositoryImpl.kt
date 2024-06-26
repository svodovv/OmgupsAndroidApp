package com.example.omgupsandroidapp.data.repository

import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi

import com.example.omgupsandroidapp.data.remote.dto.SheduleDto
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.domain.repository.ServiceRepository
import javax.inject.Inject


class ServiceRepositoryImpl @Inject constructor(
     private val serviceApi: ServiceApi
) : ServiceRepository {

    override suspend fun getScholarship(): ScholarshipDto {
        return serviceApi.getScholarship()
    }

    override suspend fun getOrder(): OrderDto{
        return serviceApi.getOrders()
    }

    override suspend fun getShudele(): SheduleDto {
        return serviceApi.getShudule()
    }
}