package com.omgupsapp.di

import com.omgupsapp.data.local.Room.AppDatabase
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import javax.inject.Inject

class MyCookieJar @Inject constructor(
    private val appDatabase: AppDatabase
) : CookieJar {

  /*  override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {*//*
                val hostCookies = cookieStore[url.host] ?: ArrayList()
                hostCookies.addAll(cookies)
                cookieStore[url.host] = hostCookies
        *//**//*   appDatabase.cookieDao()
            .deleteCookiesAndAddCookiesTransaction(cookies
                .map {
                    CookieEntity(cookieString = it.toString())
                })*//*
    }


    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return appDatabase.cookieDao().getAllCookies().map {
                Cookie.parse(url = url, setCookie = it)!!
            }
    }*/
  private val cookieStore = HashMap<String, MutableList<Cookie>>()

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        val hostCookies = cookieStore[url.host] ?: ArrayList()
        hostCookies.addAll(cookies)
        cookieStore[url.host] = hostCookies
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return cookieStore[url.host] ?: ArrayList()
    }
}
