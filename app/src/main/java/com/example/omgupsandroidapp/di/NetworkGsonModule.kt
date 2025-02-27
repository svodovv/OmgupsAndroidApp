package com.example.omgupsandroidapp.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.ContextCompat.getSystemService
import androidx.datastore.preferences.protobuf.Api
import com.example.fooddeliverygosport.di.interceptors.OnlineInterceptor
import com.example.omgupsandroidapp.OmgupsApplication
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.example.omgupsandroidapp.data.local.Room.Cookie.MyCookieJar
import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi
import com.example.omgupsandroidapp.data.remote.Retrofit.UserInfoApi
import com.google.gson.Gson
import com.omgupsapp.common.Constants
import com.omgupsapp.common.Constants.BASE_URL
import com.omgupsapp.data.remote.Retrofit.AuthApi
import com.omgupsapp.di.NetworkScalarsModule
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
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


/*@Module
//@Suppress("unused")
@InstallIn(SingletonComponent::class)
object NetworkGsonModule {

    private val READ_TIMEOUT = 30
    private val WRITE_TIMEOUT = 30
    private const val CONNECTION_TIMEOUT = 10
    private val CACHE_SIZE_BYTES = 10 * 1024 * 1024L // 10 MB


    /*@Provides
    @Singleton
    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    var cache: Cache = Cache(File("cache-directory"), (10 * 1024 * 1024).toLong()) // 10 МБ



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
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): OmgupsApplication {
        return app as OmgupsApplication
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor: Interceptor,
        cache: Cache,
       //a cookieJar: MyCookieJar,
        context: Context
    ): OkHttpClient {

        val okHttpClientBuilder = OkHttpClient().newBuilder().addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY))
            //.cookieJar(cookieJar)
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
            }).cache(NetworkGsonModule.cache).build()
        okHttpClientBuilder.cache(cache).build()
        okHttpClientBuilder.addInterceptor(headerInterceptor)


        return okHttpClientBuilder.build()
    }*/


    @Provides
    //@Singleton
    fun isOnline(@ApplicationContext context: Context): Boolean {
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

    @Provides
    @Singleton
    @Named("gson")
    fun provideRetrofitGson(
        okHttpClient: OkHttpClient,
        @ApplicationContext context: Context
    ): Retrofit {

        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)

        OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                    request = if(isOnline(context))
                        request.newBuilder()
                            .cacheControl(
                                CacheControl.Builder()
                                    .maxAge(30,TimeUnit.MINUTES)
                                    .build()
                            ).build()
                else
                    request
                        .newBuilder()
                        .cacheControl(
                            CacheControl.Builder()
                                .build()
                        ).build()
                chain.proceed(request)
            }.addInterceptor(HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY }
            )
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(Retrofit::class.java)

        /*val instance: Api by lazy {
            val myCache = Cache(context.cacheDir, cacheSize)

            val okHttpClient = OkHttpClient.Builder()
                .cache(myCache)
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
                }
                .addInterceptor(HttpLoggingInterceptor().apply {
                    this.level = HttpLoggingInterceptor.Level.BODY }
                )
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("BASE_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            retrofit.create(Api::class.java)
        }

        return retrofit.create(Api::class.java)*/
        /*return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()*/
    }



   /* @Provides
    @Singleton
    @Named("gsonOkHttp")

    fun provideOkHttpClientCache(context: Context): OkHttpClient {
        val cacheSize = (10 * 1024 * 1024).toLong()
        val cache = Cache(context.cacheDir, cacheSize)

        val cacheInterceptor = Interceptor { chain ->
            val originalResponse = chain.proceed(chain.request())
            val cacheControl = originalResponse.header("Cache-Control")

            if (cacheControl == null || cacheControl.contains("no-store") ||
                cacheControl.contains("no-cache") || cacheControl.contains("must-revalidate") ||
                cacheControl.contains("max-age=0")
            ) {
                originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=${86400}")
                    .build()
            } else {
                originalResponse
            }
        }

        return OkHttpClient.Builder()
            .addNetworkInterceptor(cacheInterceptor)
            .cache(cache)
            .build()
    }

    val offlineInterceptor = Interceptor { chain ->
        var request = chain.request()
        if (!isOnline()) {
            request = request.newBuilder()
                .header("Cache-Control", "public, only-if-cached")
                .build()
        }
        chain.proceed(request)
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(offlineInterceptor)
        .build()

    // Helper method to check network connectivity
    fun provideOkHttpClientisOnline(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }*/


    @Provides
    @Singleton
       fun provideServiceApi(@Named("gson") retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserInfoApi(@Named("gson") retrofit: Retrofit): UserInfoApi {
        return retrofit.create(UserInfoApi::class.java)
    }

}*/

/*@Module
@Suppress("unused")
@InstallIn(SingletonComponent::class)
object NetworkGsonModule {

    val cacheSize = (5 * 1024 * 1024).toLong()
    var cache: Cache = Cache(File("cache-directory"), (10 * 1024 * 1024).toLong())


    val cachingInterceptor = Interceptor {
            chain ->
        val originalResponse = chain.proceed(chain.request())
        val cacheControl = originalResponse.header("Cache-Control")
        if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
            cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0")
        ) {
            // No cache headers, skip caching
            originalResponse
        } else {
            val maxAge = 60 // Cache for 1 minute, because patience is not always a virtue
            originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=$maxAge")
                .build()
        }
    }

    @Provides
    @Singleton
    fun isOnline(@ApplicationContext context: Context): Boolean {
        /* val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         val networkInfo = connectivityManager.activeNetworkInfo
         return networkInfo != null && networkInfo.isConnected*/
        val connectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    @Provides
    @Singleton
    @Named("gsonOkHttp")
    fun provideGsonOkHttpClient(
        cookieJar: MyCookieJar,
        @ApplicationContext context: Context,
    ): OkHttpClient {
        val cacheSize = (10 * 1024 * 1024).toLong() // 5 MB
        val cacheDir = File(context.cacheDir, "http-cache")
        val cache = Cache(cacheDir, cacheSize)
        /*chain.request()
        val request = if (isOnline(context))
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
        chain.proceed(request)*/
        return OkHttpClient.Builder()
            .addInterceptor{
                chain ->
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

            }
            .cache(cache)
            .addNetworkInterceptor(cachingInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .cookieJar(cookieJar).build()
    }


    @Provides
    @Singleton
    @Named("gson")
    fun provideRetrofitGson(
        @Named("gsonOkHttp") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    /*val httpClientWithCache = OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(cachingInterceptor)
        .build()

    val retrofit = Retrofit.Builder() // Your API base URL, where all the magic happens
        .client(httpClientWithCache)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ServiceApi::class.java)*/

    /*@Provides
    @Singleton
    fun provideServiceApi(@Named("gson") retrofit: Retrofit): ServiceApi {

        return retrofit.create(ServiceApi::class.java)
    }*/
    @Provides
    @Singleton
    fun provideServiceApi(@Named("gson") retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserInfoApi( @Named("gson") retrofit: Retrofit): UserInfoApi {
        return retrofit.create(UserInfoApi::class.java)
    }
   /* private val READ_TIMEOUT = 30
    private val WRITE_TIMEOUT = 30
    private const val CONNECTION_TIMEOUT = 10
    private val CACHE_SIZE_BYTES = 10 * 1024 * 1024L // 10 MB
    var cache: Cache = Cache(File("cache-directory"), (10 * 1024 * 1024).toLong())

    @Provides
    fun providesIsOnline(@ApplicationContext context: Context): Boolean {
        val connectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .cache(cache) // Если нужен кэш
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) // Логирование запросов
            .build()
    }

    @Provides
    @Singleton
    @Named("gson")
    fun provideRetrofitGson(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideServiceApi(@Named("gson") retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserInfoApi(@Named("gson") retrofit: Retrofit): UserInfoApi {
        return retrofit.create(UserInfoApi::class.java)
    }*/


}
 */

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

        val cacheSize = (100 * 1024 * 1024).toLong() // 10 MB
        val cacheDir = File(context.cacheDir, "http-cache")
        val cache = Cache(cacheDir, cacheSize)

        // Interceptor for providing a max-age for cached responses when online
        val onlineCacheInterceptor = Interceptor { chain ->
            val response = chain.proceed(chain.request())
            response.newBuilder()
                .header("Cache-Control", "public, max-age=86400, stale-while-revalidate=864000")
//                .header("Cache-Control", "public, max-age=" + 86400) // Cache for 1 minute
                .build()
        }

        // Interceptor for using stale cache if offline
        val offlineCacheInterceptor = Interceptor { chain ->
            var request = chain.request()
            if (!onlineInterceptor.isNetworkAvailable(context)) { // Assuming isNetworkAvailable() checks connectivity
                request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE) // Force use of cache if offline
                    .header("Cache-Control", "public, only-if-cached, max-stale=86400")
                    .build()
            }
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(offlineCacheInterceptor) // Use stale cache when offline
            .addNetworkInterceptor(onlineCacheInterceptor) // Use cache when online
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .cookieJar(cookieJar)
            .build()
    }

    @Provides
    @Singleton
    @Named("gson")
    fun provideRetrofitGson(
        @Named("gsonOkHttp") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApi(@Named("gson") retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceApi(@Named("gson") retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserInfoApi(@Named("gson") retrofit: Retrofit): UserInfoApi {
        return retrofit.create(UserInfoApi::class.java)
    }
}

/*@Module
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
    fun provideServiceApi(@Named("gson") retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserInfoApi( @Named("gson") retrofit: Retrofit): UserInfoApi {
        return retrofit.create(UserInfoApi::class.java)
    }

}*/