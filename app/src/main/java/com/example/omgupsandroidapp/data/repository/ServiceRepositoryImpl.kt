package com.example.omgupsandroidapp.data.repository

import android.util.Log
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto

import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.example.omgupsandroidapp.domain.repository.ServiceRepository
import com.omgupsapp.common.Resource
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Named


class ServiceRepositoryImpl @Inject constructor(
      private val serviceApi: ServiceApi
) : ServiceRepository {

    override suspend fun getScholarship(): ScholarshipDto {
        return serviceApi.getScholarship()
    }
    /*override suspend fun postSpravka(csrfToken: String,type : Int, count : Int): Resource<SpravkaPostModel> {
        return serviceApi.postSpravka(csrfToken,type,count)
    }*/
    override suspend fun postSpravka(post: SpravkaPostModel): Resource<SpravkaPostModel> {
        return serviceApi.postSpravka(post)
    }


    override suspend fun getOrder(): OrderDto{
        return serviceApi.getOrders()
    }

    override suspend fun getTypesSravki(): TypeSpravkaDto {
        return serviceApi.getTypesSpravki()
    }

}