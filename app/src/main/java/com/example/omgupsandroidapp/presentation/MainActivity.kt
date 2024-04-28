package com.example.omgupsandroidapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.omgupsandroidapp.presentation.theme.OmgupsAndroidAppTheme
import com.omgupsapp.data.local.DataStore.DataStoreManager
import com.omgupsapp.presentation.App
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var dataStoreManager: DataStoreManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            OmgupsAndroidAppTheme() {
                val navController = rememberNavController()
                App(dataStoreManager, navController)
            }
        }
    }
}

