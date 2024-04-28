package com.example.omgupsandroidapp.domain.use_case.signIn

import android.util.Log
import com.omgupsapp.data.local.DataStore.DataStoreManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) {
    fun isUserSignIn(): Flow<Boolean> = flow {
        try {
             dataStoreManager.getLoggedIn().collect{
                emit(it)
            }
        }
        catch (e: IOException){
            Log.e("signInUseCase", " exception $e")
        }
    }

}