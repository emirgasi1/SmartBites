package com.example.smartbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.smartbites.ui.theme.SmartBitesTheme
import com.example.smartbites.ui.navigation.AppNavHost
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            val navController = rememberNavController()
            SmartBitesTheme(darkTheme = darkTheme) {
                AppNavHost(navController = navController, darkTheme = darkTheme)
            }
        }
    }
}