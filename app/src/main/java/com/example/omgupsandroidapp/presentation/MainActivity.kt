package com.example.omgupsandroidapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.omgupsandroidapp.presentation.theme.OmgupsAndroidAppTheme
import com.omgupsapp.presentation.App
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            OmgupsAndroidAppTheme {
                val navController = rememberNavController()
                App(navController)
            }
        }
    }
}

