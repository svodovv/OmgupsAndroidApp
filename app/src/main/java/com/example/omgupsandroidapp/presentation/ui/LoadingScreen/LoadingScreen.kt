package com.example.omgupsandroidapp.presentation.ui.LoadingScreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.omgupsandroidapp.R

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(
        spec = if (isSystemInDarkTheme()) {
            LottieCompositionSpec.RawRes(R.raw.lottie_loading_dark)
        } else LottieCompositionSpec.RawRes(R.raw.lottie_loading_ligth)
    )
    val progress = animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = 1f,
        isPlaying = true,
        clipSpec = LottieClipSpec.Progress(0f, 1f),

        )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.size(200.dp)) {
            LottieAnimation(composition = composition, progress = { progress.progress })
        }
    }
}