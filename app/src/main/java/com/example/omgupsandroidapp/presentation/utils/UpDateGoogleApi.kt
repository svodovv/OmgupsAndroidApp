package com.example.omgupsandroidapp.presentation.utils

import android.app.Activity.RESULT_OK
import android.content.Context
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.components.UpDateStateGoogle
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UpDateGoogleApi @Inject constructor(private val context: Context) : ViewModel() {

    private val updateLauncher = registerUpdateLauncher()
    private val appUpdateManager: AppUpdateManager by lazy {
        AppUpdateManagerFactory.create(context)
    }
    private val upDateType = AppUpdateType.IMMEDIATE

    val _updateStateGoodle = MutableStateFlow(UpDateStateGoogle())
    val updateStateGoodle = _updateStateGoodle.asStateFlow()

    val listener = InstallStateUpdatedListener { state ->
        // (Optional) Provide a download progress bar.
        if (state.installStatus() == InstallStatus.DOWNLOADING) {
            val bytesDownloaded = state.bytesDownloaded()
            val totalBytesToDownload = state.totalBytesToDownload()
            // Show update progress bar.
        }
        // Log state or install the update.
    }

    /*private fun registerUpdateLauncher(): ActivityResultLauncher<IntentSenderRequest> {
        return ActivityResultLauncherRegistry.register(
            "updateLauncherKey",
            ActivityResultContracts.StartIntentSenderForResult()
        ) { result ->
            // Обработка результата обновления
            if (result.resultCode == RESULT_OK) {
                Log.d(TAG, "Update successful!")
            } else {
                Log.e(TAG, "Update failed: ${result.resultCode}")
            }
        }
    }*/

    fun googleAppUpdateManagerGetAppUpdateInfo(context: Context) {
        val appUpdateManager = AppUpdateManagerFactory.create(context)
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            Log.e(TAG, appUpdateInfo.updateAvailability().toString())
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                // This example applies an immediate update. To apply a flexible update
                // instead, pass in AppUpdateType.FLEXIBLE
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                _updateStateGoodle.update {
                    UpDateStateGoogle().copy(
                        upDateState = 2
                    )
                }
            }
        }
    }

    companion object {
        private const val TAG = "MainViewModelGoogleApi"
    }

    override fun onCleared() {
        super.onCleared()
        appUpdateManager.unregisterListener(listener)

        /*appUpdateInfo.addOnSuccessListener { info ->
            if (info.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS){
                appUpdateManager.startUpdateFlowForResult(
                    info,
                    updateLauncher,
                    AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
                )
            }
        }*/
    }

    fun initUpDateFromGooglePlay(context: Context){
        val appUpdateManager = AppUpdateManagerFactory.create(context)
        appUpdateManager
            .appUpdateInfo
            .addOnSuccessListener { appUpdateInfo ->
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        updateLauncher,
                        AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
                    )
            }
    }

}