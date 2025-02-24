package com.example.omgupsandroidapp.presentation.utils

import android.content.Context
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory

class InAppUpDateGoogle(val context: Context) {

    private val appUpdateManager = AppUpdateManagerFactory.create(context)



}