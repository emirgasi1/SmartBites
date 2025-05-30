package com.example.smartbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartbites.ui.screens.*
import com.example.smartbites.ui.theme.SmartBitesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartBitesTheme {
                val navController = rememberNavController()
                Surface {
                    AppNavHost(navController)
                }
            }
        }
    }
}

fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "height_screen") {

        composable("height_screen") {
            HeightScreen(navController)
        }

        composable("weight_screen") {
            WeightScreen(navController)
        }

        composable("target_weight_screen") {
            TargetWeightScreen(navController)
        }

        composable("goal_screen") {
            GoalScreen(navController)
        }

        composable("speed_screen") {
            SpeedScreen(navController)
        }

        composable("final_step_screen") {
            androidx.compose.foundation.layout.Box(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .background(androidx.compose.ui.graphics.Color.Black),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                androidx.compose.material3.Text(
                    text = "Step 9 Screen",
                    color = androidx.compose.ui.graphics.Color.White
                )
            }
        }
    }
}
