package com.example.omgupsandroidapp.data.local.Room.Cookie

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import javax.inject.Inject

class MyCookieJar @Inject constructor(
    private val cookieDao: CookieDao
) : CookieJar {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        coroutineScope.launch {
            for (cookie in cookies) {
                cookieDao.insertCookie(
                    CookieEntity(
                        host = url.host,
                        name = cookie.name,
                        value = cookie.value,
                        expiresAt = System.currentTimeMillis() + 50000
                    )
                )
            }
        }
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {

        val cookieEntities = cookieDao.getCookiesForHost(url.host)
        val cookie = cookieEntities.map { entity ->
            Cookie.Builder().name(entity.name)
                .value(entity.value)
                .domain(url.host)
                .path("/")
                .httpOnly()
                //.expiresAt(entity.expiresAt)
                .build()
        }

        return cookie
    }
}
