package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto

import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.omgupsapp.common.Resource
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface ServiceApi {

    @GET("student/getstipend")
    suspend fun getScholarship(): ScholarshipDto

    @GET("student/getorders")
    suspend fun getOrders(): OrderDto

    /*@POST("spravkaapi/spravka/create")
    suspend fun postSpravka(
        @Body post: LoadSpravkaDto
    ): Response<LoadSpravkaDto>*/

    @POST("spravkaapi/spravka/create")
    suspend fun postSpravka(
        @Body post: LoadSpravkaDto
    ): LoadSpravkaDto

   /* @GET("student/gethistory?type={id}")
    suspend fun getReferenceHistory(@Query("id") id: Int): ReferenceHistoryDto*/
   @GET("student/gethistory")
   suspend fun getReferenceHistory(@Query("type") id: Int): ReferenceHistoryDto
    @GET("student/gettypes")
    suspend fun getTypesSpravki(): TypeSpravkaDto

    @GET("student/getstatus")
    suspend fun getStatysSpravka(@Query("type") id: Int): StatusSpravakaDto







    /*@FormUrlEncoded
    @POST("student/loadspravka")
    suspend fun postSpravka(
        @Field("_csrf") csrfToken: String,
        @Field("type") type: Int,
        @Field("count") count: Int,
    ): Resource<SpravkaPostModel>*/

}