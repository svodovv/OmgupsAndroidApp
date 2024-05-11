package com.omgupsapp.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.data.remote.Retrofit.AuthApi
import com.omgupsapp.domain.repository.AuthRepository
import org.jsoup.Jsoup
import javax.inject.Inject
import javax.inject.Named


/*

    По скольку сервер не расчитан на мобилку всегда приходит HTTP ответ 200
    (учитывается только правильный запрос, если запрос был неккоректен, то он выкинет 400),
    даже если был введ не правильный пароль, из-за этого приходиться парсить содержмое страницы входа
     , на lktest и проде разное содержиое страницы входа,
      по этому работать в разных ветках
*/

class AuthRepositoryImpl @Inject constructor(

    private val api: AuthApi,
    private val dataStoreManager: DataStoreManager
) : AuthRepository {

    private var csrfToken: String? = null

    override suspend fun tokenExists(): Boolean {
        val response = api.getHtmlAuthPage()
        return if (response.isSuccessful) {
            csrfToken = response.body()?.let {
                parseMetaDataInHtmlDoc(it, "csrf-token")
            }
            csrfToken != null
        } else {
            Log.e(TAG, "repository did not receive a token")
            false
        }
    }


    override suspend fun authentication(
        login: String,
        password: String,
    ): Boolean {
        Log.e("TOKEN", csrfToken.toString() )
        val response = api.authentication(
            csrfToken = csrfToken!!,
            login = login,
            password = password,
            rememberMe = "1"
        )
        if (response.isSuccessful){
            val title = response.body()?.let {
                parseTitleInHtmlDoc(it)
            }
            if (title != null && title.contains("кабинет")) {
                dataStoreManager.saveLoggedIn(true)
                return true
            }
        }
        return false
    }

    private fun parseMetaDataInHtmlDoc(htmlContent: String, metaName: String): String? {
        return try {
            val element = Jsoup.parse(htmlContent).select("meta[name=$metaName]").first()
            element?.attr("content")
        } catch (e: Exception) {
            e.printStackTrace()
            "Error in parsing fun"
        }
    }

    private fun parseTitleInHtmlDoc(htmlContent: String): String? {
        return Jsoup.parse(htmlContent).title()
    }
}