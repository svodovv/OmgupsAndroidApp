package com.omgupsapp.data.repository

import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao
import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.data.remote.Retrofit.LogoutApi
import com.omgupsapp.domain.repository.LogoutRepository
import javax.inject.Inject

class LogoutRepositoryImpl @Inject constructor(
    val dataStoreManager: DataStoreManager, val api: LogoutApi, private val cookieDao: CookieDao
) : LogoutRepository {
    override suspend fun logout() {

        dataStoreManager.saveLoggedIn(false)
        cookieDao.deleteAllCookies()
        api.logout()

    }
}