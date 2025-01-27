package com.example.omgupsandroidapp.data.remote.Retrofit

import com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.AcademicPlanDto
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.AcademicPlanDtoItem
import com.example.omgupsandroidapp.data.remote.dto.gradeBook.ListGradeDto
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto
import com.example.omgupsandroidapp.data.remote.dto.schedule.ShedelItem
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.SpravkaResponse
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.omgupsapp.common.Resource
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface ServiceApi {

    @GET("userapi/v1/academic-plan/get-plans")
    suspend fun getAcademicPlan(): AcademicPlanDto

    //@Headers("Cache-Control: max-age=3600")
    @GET("userapi/v1/stipend/get-stipend")
    suspend fun getScholarship(): ScholarshipDto

    //@Headers("Cache-Control: max-age=3600")
    @GET("userapi/v1/orders/get-orders")
    suspend fun getOrders(): OrderDto

    //@Headers("Cache-Control: max-age=3600")
    @GET("userapi/v1/schedule/get-schedule")
    suspend fun getShudule(): List<ScheduleEntity>

    @POST("userapi/v1/spravka/create-spravka")
    suspend fun postSpravka(
        @Body post: LoadSpravkaDto
    ): SpravkaResponse

    @GET("userapi/v1/spravka/get-history")
    suspend fun getReferenceHistory(@Query("type") id: Int): ReferenceHistoryDto

    @GET("userapi/v1/spravka/get-types")
    suspend fun getTypesSpravki(): TypeSpravkaDto

    @GET("userapi/v1/spravka/get-status")
    suspend fun getStatysSpravka(@Query("type") id: Int): StatusSpravakaDto

    @GET("userapi/v1/grade/get-grades")
    suspend fun getGradeBooks(): ListGradeDto







    /*@FormUrlEncoded
    @POST("student/loadspravka")
    suspend fun postSpravka(
        @Field("_csrf") csrfToken: String,
        @Field("type") type: Int,
        @Field("count") count: Int,
    ): Resource<SpravkaPostModel>*/

}