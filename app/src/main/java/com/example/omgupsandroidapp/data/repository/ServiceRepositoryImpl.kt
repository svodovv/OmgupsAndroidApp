package com.example.omgupsandroidapp.data.repository

import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDtoItem
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList

import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.toDtoLoadSpravka
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.example.omgupsandroidapp.domain.repository.ServiceRepository
import com.omgupsapp.common.Resource
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class ServiceRepositoryImpl @Inject constructor(
      private val serviceApi: ServiceApi
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

    override suspend fun postSpravka(post: LoadSpravka): Call<ResponseBody> {
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

}