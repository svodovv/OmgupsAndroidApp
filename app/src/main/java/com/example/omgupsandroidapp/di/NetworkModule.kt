package com.omgupsapp.di

import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.example.omgupsandroidapp.data.local.Room.Cookie.MyCookieJar
import com.omgupsapp.common.Constants
import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.data.remote.Retrofit.AuthApi
import com.omgupsapp.data.remote.Retrofit.LogoutApi
import com.omgupsapp.data.local.Room.AppDatabase
import com.omgupsapp.data.repository.AuthRepositoryImpl
import com.omgupsapp.data.repository.LogoutRepositoryImpl
import com.omgupsapp.domain.repository.AuthRepository
import com.omgupsapp.domain.repository.LogoutRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideMyCookieJar(cookieDao: CookieDao): MyCookieJar {
        return MyCookieJar(cookieDao)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cookieJar: MyCookieJar): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .cookieJar(cookieJar)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
        ): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun authApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }


    @Provides
    @Singleton
    fun provideAuthRepository(
        api: AuthApi,
        dataStoreManager: DataStoreManager
    ): AuthRepository {
        return AuthRepositoryImpl(api, dataStoreManager)
    }

    @Provides
    @Singleton
    fun logoutApi(retrofit: Retrofit): LogoutApi {
        return retrofit.create(LogoutApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLogoutRepository(
        api: LogoutApi,
        dataStoreManager: DataStoreManager,
        cookieDao: CookieDao
    ): LogoutRepository {
        return LogoutRepositoryImpl(api = api, dataStoreManager = dataStoreManager, cookieDao = cookieDao)
    }
}
