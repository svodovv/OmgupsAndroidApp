package com.example.omgupsandroidapp.di

import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.omgupsapp.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkGsonModule {


    @Provides
    @Singleton
    @Named("gson")
    fun provideRetrofitGson(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
       fun provideServiceApi(   @Named("gson") retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

}