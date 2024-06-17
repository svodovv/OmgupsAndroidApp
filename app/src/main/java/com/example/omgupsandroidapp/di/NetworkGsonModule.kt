package com.example.omgupsandroidapp.di

import android.content.Context
import com.example.fooddeliverygosport.di.interceptors.OnlineInterceptor
import com.example.omgupsandroidapp.data.local.Room.Cookie.MyCookieJar
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.omgupsapp.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkGsonModule {


    @Provides
    @Singleton
    @Named("gsonOkHttp")
    fun provideGsonOkHttpClient(
        cookieJar: MyCookieJar,
        @ApplicationContext context: Context,
        onlineInterceptor: OnlineInterceptor,
        ): OkHttpClient {

        val cacheSize = (10 * 1024 * 1024).toLong() // 5 MB
        val cacheDir = File(context.cacheDir, "http-cache")
        val cache = Cache(cacheDir, cacheSize)

        return OkHttpClient.Builder()

            //.addNetworkInterceptor(onlineInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar).build()
    }

    @Provides @Singleton @Named("gson")
    fun provideRetrofitGson(
        @Named("gsonOkHttp")
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