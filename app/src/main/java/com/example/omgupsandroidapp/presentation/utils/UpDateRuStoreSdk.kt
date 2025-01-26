package com.example.omgupsandroidapp.presentation.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.components.UpDateState
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen.SpravkiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.rustore.sdk.appupdate.listener.InstallStateUpdateListener
import ru.rustore.sdk.appupdate.manager.RuStoreAppUpdateManager
import ru.rustore.sdk.appupdate.manager.factory.RuStoreAppUpdateManagerFactory
import ru.rustore.sdk.appupdate.model.AppUpdateInfo
import ru.rustore.sdk.appupdate.model.AppUpdateOptions
import ru.rustore.sdk.appupdate.model.AppUpdateType
import ru.rustore.sdk.appupdate.model.InstallStatus
import ru.rustore.sdk.appupdate.model.UpdateAvailability
import javax.inject.Inject

@HiltViewModel
class RuStoreUpDateViewModel @Inject constructor() : ViewModel() {
    private lateinit var ruStoreAppUpdateManager: RuStoreAppUpdateManager
    private val _events = MutableSharedFlow<Event>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val _updateState = MutableStateFlow(UpDateState())
    val updateState = _updateState.asStateFlow()

    /*init {
        ruStoreAppUpdateManagerGetAppUpdateInfo()
    }*/

    val events = _events.asSharedFlow()
    private val installStateUpdateListener = InstallStateUpdateListener { installState ->
        when (installState.installStatus) {
            InstallStatus.DOWNLOADED -> {
                _events.tryEmit(Event.UpdateCompleted)
            }
            InstallStatus.DOWNLOADING -> {
                val totalBytes = installState.totalBytesToDownload
                val bytesDownloaded = installState.bytesDownloaded
                // Здесь можно отобразить прогресс скачивания
            }
            InstallStatus.FAILED -> {
                Log.e(TAG, "Downloading error")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        ruStoreAppUpdateManager.unregisterListener(installStateUpdateListener)
    }

    fun ruStoreAppUpdateManagerGetAppUpdateInfo(context: Context){
        val GetAppUpdateInfo = RuStoreAppUpdateManagerFactory.create(context)
        GetAppUpdateInfo.getAppUpdateInfo().addOnSuccessListener{ appUpdateInfo ->
            //Log.e(TAG, appUpdateInfo.updateAvailability.toString())
            if (appUpdateInfo.updateAvailability == UpdateAvailability.UPDATE_AVAILABLE ) {
                _updateState.update {
                    UpDateState().copy(
                        upDateState = 2
                    )
                }
                Log.e(TAG, _updateState.value.upDateState.toString())
            }
        }
    }

    fun init(context: Context) {
        // В данном примере подобное создание класса сделано для упрощения. В реальных проектах
        // рекомендуеся использовать DI
        ruStoreAppUpdateManager = RuStoreAppUpdateManagerFactory.create(context)
        ruStoreAppUpdateManager
            .getAppUpdateInfo()
            .addOnSuccessListener { appUpdateInfo ->
                Log.e("resultCode", appUpdateInfo.toString())
                if (appUpdateInfo.updateAvailability == UpdateAvailability.UPDATE_AVAILABLE) {
                    ruStoreAppUpdateManager.registerListener(installStateUpdateListener)
                    ruStoreAppUpdateManager
                        .startUpdateFlow(appUpdateInfo, AppUpdateOptions.Builder().build())
                        .addOnSuccessListener { resultCode ->
                            Log.e("installStatus", appUpdateInfo.installStatus.toString())
                            if (resultCode == Activity.RESULT_CANCELED) {
                                // Пользователь отказался от скачивания
                            }
                            if (appUpdateInfo.installStatus == 1) {
                                completeUpdateRequested()
                            }
                        }
                        .addOnFailureListener { throwable ->
                            Log.e(TAG, "startUpdateFlow error", throwable)
                        }
                }
            }
            .addOnFailureListener { throwable ->
                Log.e(TAG, "getAppUpdateInfo error", throwable)
            }
    }

    fun completeUpdateRequested() {
        ruStoreAppUpdateManager.completeUpdate(
            AppUpdateOptions.Builder().appUpdateType(
            AppUpdateType.FLEXIBLE).build())
            .addOnFailureListener { throwable ->
                Log.e(TAG, "completeUpdate error", throwable)
            }
    }
    companion object {
        private const val TAG = "MainViewModel"
    }
}
sealed class Event {
    object UpdateCompleted : Event()
}



