package com.example.omgupsandroidapp

import android.app.Application
import com.omgupsapp.data.repository.parseMetaDataInHtmlDoc
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class OmgupsApplication @Inject constructor(): Application() {
}