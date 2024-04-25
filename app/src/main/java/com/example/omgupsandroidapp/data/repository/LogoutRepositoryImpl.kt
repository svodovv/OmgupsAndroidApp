package com.omgupsapp.data.repository

import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.data.remote.Retrofit.LogoutApi
import com.omgupsapp.domain.repository.LogoutRepository
import javax.inject.Inject

class LogoutRepositoryImpl @Inject constructor(
    val dataStoreManager: DataStoreManager, val api: LogoutApi
) : LogoutRepository {
    override suspend fun logout() {

        //ДОПИСАТЬ
        dataStoreManager.saveLoggedIn(false).also {

            api.logout()
        }

    }
}