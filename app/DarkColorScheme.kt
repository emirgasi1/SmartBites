package com.example.smartbites.ui.theme

import android.os.Build
import androidx.compose.material3.*
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.isSystemInDarkTheme

// Dark color scheme with black background and white text
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00C896), // #00c896
    secondary = Color(0xFF00C896), // #00c896
    tertiary = Color(0xFF00C896), // #00c896
    background = Color(0xFF282727),  // #282727 (dark grey)
    onBackground = Color.White, // White text on dark background
    surface = Color(0xFF282727), // Same as background
    onSurface = Color.White    // White text on dark surface
)

// Light color scheme with custom color and white background
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00C896), // #00c896
    secondary = Color(0xFF00C896), // #00c896
    tertiary = Color(0xFF00C896), // #00c896
    background = Color.White,  // White background in light mode
    onBackground = Color.Black, // Black text on white background
    surface = Color.White,     // White surface
    onSurface = Color.Black    // Black text on surface for light mode
)

// Custom Typography for titles and text
val titleTypography = Typography(
    titleLarge = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White // Default white color for title in dark mode
    ),
    titleMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium
    ),
    titleSmall = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal
    )
)

@Composable
fun SmartBitesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Dynamically apply color schemes for Android 12+ if enabled
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme // Use dark color scheme
        else -> LightColorScheme // Use light color scheme
    }

    // Apply the MaterialTheme with the selected color scheme and typography
    MaterialTheme(
        colorScheme = colorScheme,
        typography = titleTypography,  // Use custom typography here
        content = content
    )
}
