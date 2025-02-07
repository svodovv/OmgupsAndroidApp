package com.example.omgupsandroidapp.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.omgupsandroidapp.presentation.ui.theme.OmgupsAndroidAppTheme
import com.my.tracker.MyTracker
import com.my.tracker.MyTrackerConfig
import com.omgupsapp.common.Constants.SDK_KEY
import com.omgupsapp.presentation.App
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // MyTracker.setDebugMode(true)
        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()

        MyTracker.initTracker(SDK_KEY, application)

        @SuppressLint("HardwareIds")
        fun getAndroidId(context: Context): String?
        {
            try
            {
                val cr = context.contentResolver
                if (cr != null)
                {
                    return Settings.Secure.getString(cr, Settings.Secure.ANDROID_ID)
                }
            } catch (e: Throwable)
            {
            }
            return null
        }
        fun trackLogin(ignored: View)
        {
            // you can add custom params you want to track to all events
            // can be omitted or null
            val eventCustomParams: MutableMap<String, String> = HashMap()
            eventCustomParams["someParamKey"] = "someParamValue"
            MyTracker.trackLoginEvent("custom_user_id", "vk_connect_id", eventCustomParams)
            Toast.makeText(this, "Tracking login", Toast.LENGTH_SHORT).show()
        }
        setContent {

            OmgupsAndroidAppTheme {
                val navController = rememberNavController()
                App(navController)
            }
        }
    }
}

