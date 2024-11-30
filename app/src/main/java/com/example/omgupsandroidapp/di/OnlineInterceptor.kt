package com.example.fooddeliverygosport.di.interceptors

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.omgupsapp.data.repository.AuthRepositoryImpl
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class OnlineInterceptor  @Inject constructor(
    private val logOutRepositoryImpl: AuthRepositoryImpl
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val coroutineScope = CoroutineScope(Dispatchers.IO)

        val response: Response = chain.proceed(chain.request())

        return response.newBuilder()
            .header("Connection", "Keep-Alive")
            .header("Pragma", "no-cache")
            //.header("Cache-Control", "max-stale, only-if-cached")
            //.header("Cache-Control", "no-store, no-cache, must-revalidate")
            .header("Cache-Control", "public, only-if-cached")
            .header("Referrer-Policy", "strict-origin-when-cross-origin")
            .header("X-Content-Type-Options", "nosniff")
            .header("X-Frame-Options", "SAMEORIGIN")
            .header("X-Xss-Protection", "1; mode=block")
            .header("Strict-Transport-Security", "max-age=10; includeSubDomains")
            .build()
    }


    fun isNetworkAvailable(context: Context): Boolean {
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
    /*fun isNetworkAvailable(
        @ApplicationContext context: Context,
    ): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo != null && networkInfo.isConnected
        }
    }*/

}

/*    val response: Response = chain.proceed(chain.request())

        val cacheControl = CacheControl.Builder()
            .maxAge(2, TimeUnit.MINUTES)
            .build()

        return response.newBuilder()
            .header("Cache-Control", cacheControl.toString())
            .removeHeader("Pragma")
            .build()*/