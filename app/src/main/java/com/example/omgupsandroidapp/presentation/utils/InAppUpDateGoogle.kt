package com.example.omgupsandroidapp.presentation.utils

import android.content.Context
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.components.UpDateStateGoogle
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import dagger.hilt.android.ActivityRetainedLifecycle.OnClearedListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InAppUpDateGoogle(
    val context: Context,
    private val activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>) {

    private val appUpdateManager = AppUpdateManagerFactory.create(context)

    val _updateStateGoodle = MutableStateFlow(UpDateStateGoogle())
    val updateStateGoodle = _updateStateGoodle.asStateFlow()

    fun checkImmediateUpdate(activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>)
    {
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            val isAvailable =
                appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
            val isAllowed = appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            if(isAvailable){
                _updateStateGoodle.update {
                    UpDateStateGoogle().copy(
                        upDateState = 2
                    )
                }
            }
        }
    }

    companion object {
        private const val TAG = "InAppUpDateGoogle"
    }

    fun checkResumeUpdate(
        activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>
    ) {
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (
                appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS
                || appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                ){
                //Log.i(TAG,appUpdateInfo.updateAvailability().toString())
                starUpdate(
                    appUpdateInfo,
                    activityResultLauncher,
                    AppUpdateType.IMMEDIATE
                )
            }
        }.addOnFailureListener { throwable ->
            Log.e(TAG, "startUpdateFlow error", throwable)
        }
    }

     private fun starUpdate(
        appUpdateInfo: AppUpdateInfo,
        activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>,
        appUpdateType: Int
    ){
        appUpdateManager.startUpdateFlowForResult(
            appUpdateInfo,
            activityResultLauncher,
            AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).setAllowAssetPackDeletion(false).build()
        )
    }


}