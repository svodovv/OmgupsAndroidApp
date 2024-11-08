package com.omgupsapp.di

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.ContextCompat.getSystemService
import com.example.omgupsandroidapp.OmgupsApplication
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.example.omgupsandroidapp.data.local.Room.Cookie.MyCookieJar
import com.example.omgupsandroidapp.di.NetworkGsonModule.cachingInterceptor
import com.omgupsapp.common.Constants
import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.data.remote.Retrofit.AuthApi
import com.omgupsapp.data.remote.Retrofit.LogoutApi
import com.omgupsapp.data.repository.AuthRepositoryImpl
import com.omgupsapp.data.repository.LogoutRepositoryImpl
import com.omgupsapp.domain.repository.AuthRepository
import com.omgupsapp.domain.repository.LogoutRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


/*@Module
@InstallIn(SingletonComponent::class)
object NetworkScalarsModule {

    private val READ_TIMEOUT = 30
    private val WRITE_TIMEOUT = 30
    private const val CONNECTION_TIMEOUT = 10
    private val CACHE_SIZE_BYTES = 10 * 1024 * 1024L // 10 MB

    @Provides
    @Singleton
    fun isOnline(context: Context): Boolean {
       /* val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected*/
        val connectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw      = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    private var cache: Cache = Cache(File("cache-directory"), (10 * 1024 * 1024).toLong()) // 10 МБ

    /*// Настраиваем OkHttpClient, добавляем в него созданный кэш и перехватчики для управления данными.
    var okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(Interceptor { chain ->
            var request: Request = chain.request()
            // В случае отсутствия сети обращаемся к данным из кэша.
            if (!isOnline(context)) { // Получаем контекст приложения
                val maxStale = 60 * 60 * 24 * 28 // срок жизни данных – 4 недели
                request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                    .build()
            }
            chain.proceed(request)
        })
        .cache(cache)
        .build()

    // Создаём объект Retrofit, в который передаём настроенный OkHttpClient.
    var retrofit: Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://your.api/")
        .build()

    // Отправляем запрос, задействуя при этом кэш.
    var request: Request = Builder()
        .url("http://your.api/endpoint")
        .cacheControl(
            Builder()
                .onlyIfCached()
                .maxStale(365, TimeUnit.DAYS)
                .build()
        )
        .build()*/
    @Provides
    @Singleton
    fun provideMyCookieJar(cookieDao: CookieDao): MyCookieJar {
        return MyCookieJar(cookieDao)
    }

   /* @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): OmgupsApplication {
        return app as OmgupsApplication
    }*/

   /* @Provides
    @Singleton
    fun provideOkHttpClient(
        //headerInterceptor: Interceptor,
        cache: Cache,
        cookieJar: MyCookieJar,
        context: Context
    ): OkHttpClient {

        val okHttpClientBuilder = OkHttpClient().newBuilder().cache(cache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (isOnline(context))
                    request
                        .newBuilder()
                        .cacheControl(
                            CacheControl.Builder()
                                .maxAge(30, TimeUnit.MINUTES)
                                .build()
                        )
                        .build()
                else
                    request
                        .newBuilder()
                        .cacheControl(
                            CacheControl.Builder()
                                .maxStale(1, TimeUnit.DAYS)
                                .build()
                        )
                        .build()
                chain.proceed(request)
            }.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar)
/*.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar)
        okHttpClientBuilder.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addNetworkInterceptor(Interceptor { chain ->
                var request: Request = chain.request()
                // В случае отсутствия сети обращаемся к данным из кэша.
                if (!isOnline(context)) {
                    val maxStale = 60 * 60 * 24 * 28 // срок жизни данных – 4 недели
                    request = request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                        .build()
                }
                chain.proceed(request)
            }).cache(NetworkScalarsModule.cache).build()
        okHttpClientBuilder.cache(cache).build()
        okHttpClientBuilder.addInterceptor(headerInterceptor)*/


        return okHttpClientBuilder.build()
    }*/

    /*fun provideOkHttpClient(cookieJar: MyCookieJar): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar).build()
    }*/
  /* @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor {
            val requestBuilder = it.request().newBuilder()
            //hear you can add all headers you want by calling 'requestBuilder.addHeader(name ,  value)'
            it.proceed(requestBuilder.build())
        }
    }*/
   /* @Provides
    @Singleton
    internal fun provideCache(context: Context): Cache {
        val httpCacheDirectory = File(context.cacheDir.absolutePath, "HttpCache")
        return Cache(httpCacheDirectory, CACHE_SIZE_BYTES)
    }*/
    /*@Provides
    @Singleton
    @Named("Scalars")
    fun provideOkHttpClient(
        cookieJar: MyCookieJar,
        @ApplicationContext context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (isOnline(context)) {
                    request.newBuilder()
                        .cacheControl(CacheControl.Builder()
                            .maxAge(30, TimeUnit.MINUTES)
                            .build())
                        .build()
                } else {
                    request.newBuilder()
                        .cacheControl(CacheControl.Builder()
                            .maxStale(1, TimeUnit.DAYS)
                            .build())
                        .build()
                }
                chain.proceed(request)
            }
            .build()
    }*/


    @Provides
    @Singleton
    @Named("Scalars")
    fun provideOkHttpClient(cookieJar: MyCookieJar): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(cachingInterceptor)
            .cookieJar(cookieJar).cache(cache).build()
    }


    /*@Provides
    @Singleton
    @Named("Scalars")
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
             .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }*/

    @Provides
    @Singleton
    fun authApi(@Named("Scalars") retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }


    @Provides
    @Singleton
    fun provideAuthRepository(
        api: AuthApi, dataStoreManager: DataStoreManager
    ): AuthRepository {
        return AuthRepositoryImpl(api, dataStoreManager)
    }

    @Provides
    @Singleton
    fun logoutApi(@Named("Scalars") retrofit: Retrofit): LogoutApi {
        return retrofit.create(LogoutApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLogoutRepository(
        api: LogoutApi, dataStoreManager: DataStoreManager, cookieDao: CookieDao
    ): LogoutRepository {
        return LogoutRepositoryImpl(
            api = api, dataStoreManager = dataStoreManager, cookieDao = cookieDao
        )
    }
}*/


@Module
@InstallIn(SingletonComponent::class)
object NetworkScalarsModule {

    private var cache: Cache = Cache(File("cache-directory"), (10 * 1024 * 1024).toLong())

    @Provides
    @Singleton
    fun provideMyCookieJar(cookieDao: CookieDao): MyCookieJar {
        return MyCookieJar(cookieDao)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cookieJar: MyCookieJar): OkHttpClient {
        return OkHttpClient.Builder()//.addInterceptor(cachingInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cookieJar(cookieJar).build()
    }


    @Provides
    @Singleton
    @Named("Scalars")
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun authApi(@Named("Scalars") retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }


    @Provides
    @Singleton
    fun provideAuthRepository(
        api: AuthApi, dataStoreManager: DataStoreManager
    ): AuthRepository {
        return AuthRepositoryImpl(api, dataStoreManager)
    }

    @Provides
    @Singleton
    fun logoutApi(@Named("Scalars") retrofit: Retrofit): LogoutApi {
        return retrofit.create(LogoutApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLogoutRepository(
        api: LogoutApi, dataStoreManager: DataStoreManager, cookieDao: CookieDao
    ): LogoutRepository {
        return LogoutRepositoryImpl(
            api = api, dataStoreManager = dataStoreManager, cookieDao = cookieDao
        )
    }

}
