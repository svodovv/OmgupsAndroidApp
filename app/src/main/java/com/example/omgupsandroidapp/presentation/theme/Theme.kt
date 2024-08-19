package com.example.omgupsandroidapp.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.omgupsandroidapp.presentation.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    background = Cultered,
    onBackground = Color.Black,
    surface = SonicSilver,
    onSurface = Color.Gray,
    surfaceVariant = Color.White,
    onSecondaryContainer = LightGray,
    secondary = BlueLight,
    scrim = TranslucentBlack,
    error = Color.Red,
    onSecondary = BlueHard
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    background = Cultered,
    onBackground = Color.Black,
    surface = SonicSilver,
    onSurface = Color.Gray,
    surfaceVariant = Color.White,
    onSecondaryContainer = LightGray,
    secondary = BlueLight,
    scrim = TranslucentBlack,
    error = Color.Red,
    onSecondary = BlueHard
)

@Composable
fun OmgupsAndroidAppTheme(
    darkTheme: Boolean = false,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor =
                if (darkTheme) colorScheme.surface.toArgb() else colorScheme.primary.toArgb()

            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    val Shapes = Shapes(
        small = RoundedCornerShape(10.dp),
        medium = RoundedCornerShape(20.dp),
        large = RoundedCornerShape(30.dp)
    )
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}