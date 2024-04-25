package com.omgupsapp.di

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
    fun provideMyCookieJar(appDatabase: AppDatabase): MyCookieJar {
        return MyCookieJar(appDatabase)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cookieJar: MyCookieJar): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar)
            .build()
    }


    @Provides
    @Singleton
    fun retrofit(appDatabase: AppDatabase): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .client(provideOkHttpClient(provideMyCookieJar(appDatabase)))
            .addConverterFactory(ScalarsConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun authApi(appDatabase: AppDatabase): AuthApi {
        return retrofit(appDatabase).create(AuthApi::class.java)
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
    fun logoutApi(appDatabase: AppDatabase): LogoutApi {
        return retrofit(appDatabase).create(LogoutApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLogoutRepository(
        api: LogoutApi,
        dataStoreManager: DataStoreManager
    ): LogoutRepository {
        return LogoutRepositoryImpl(api = api, dataStoreManager = dataStoreManager)
    }


}
