package com.example.roaryminder.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roaryminder.android.ui.theme.*

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = md_theme_dark_primary,
            onPrimary = md_theme_dark_onPrimary,

            secondary = md_theme_dark_secondary,
            onSecondary = md_theme_dark_onSecondary,

            error = md_theme_dark_error,

            onError = md_theme_dark_onError,

            background = md_theme_dark_background,
            onBackground = md_theme_dark_onBackground,

            surface = md_theme_dark_surface,
            onSurface = md_theme_dark_onSurface,


        )
    } else {
        lightColors(
            primary = md_theme_light_primary,
            onPrimary = md_theme_light_onPrimary,

            secondary = md_theme_light_secondary,
            onSecondary = md_theme_light_onSecondary,

            error = md_theme_light_error,

            onError = md_theme_light_onError,

            background = md_theme_light_background,
            onBackground = md_theme_light_onBackground,


            surface = md_theme_light_surface,
            onSurface = md_theme_light_onSurface,
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
