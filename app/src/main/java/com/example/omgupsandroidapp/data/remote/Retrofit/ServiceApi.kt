package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.omgupsapp.common.Resource
import okhttp3.Request
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {

    @GET("student/getstipend")
    suspend fun getScholarship(): ScholarshipDto

    @GET("student/getorders")
    suspend fun getOrders(): OrderDto

    @POST("student/loadspravka")
    suspend fun postSpravka(
        @Body post: SpravkaPostModel
    ): Resource<SpravkaPostModel>


    @GET("student/gettypes")
    suspend fun getTypesSpravki(): TypeSpravkaDto


    /*@FormUrlEncoded
    @POST("student/loadspravka")
    suspend fun postSpravka(
        @Field("_csrf") csrfToken: String,
        @Field("type") type: Int,
        @Field("count") count: Int,
    ): Resource<SpravkaPostModel>*/

}