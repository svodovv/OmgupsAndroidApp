package com.example.fooddeliverygosport.di.interceptors

import com.example.omgupsandroidapp.data.repository.UserProfileRepositoryImpl
import com.omgupsapp.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class OnlineInterceptor  @Inject constructor(
    private val logOutRepositoryImpl: AuthRepositoryImpl
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
    /*    val response: Response = chain.proceed(chain.request())

        val cacheControl = CacheControl.Builder()
            .maxAge(2, TimeUnit.MINUTES)
            .build()

        return response.newBuilder()
            .header("Cache-Control", cacheControl.toString())
            .removeHeader("Pragma")
            .build()*/

        val coroutineScope = CoroutineScope(Dispatchers.IO)

        val response: Response = chain.proceed(chain.request())

        return response.newBuilder()
            .header("Connection", "Keep-Alive")
            .header("Pragma", "no-cache")
            .header("Cache-Control", "no-store, no-cache, must-revalidate")
            .header("Referrer-Policy", "strict-origin-when-cross-origin")
            .header("X-Content-Type-Options", "nosniff")
            .header("X-Frame-Options", "SAMEORIGIN")
            .header("X-Xss-Protection", "1; mode=block")
            .header("Strict-Transport-Security", "max-age=10; includeSubDomains")
            .build()
    }

}