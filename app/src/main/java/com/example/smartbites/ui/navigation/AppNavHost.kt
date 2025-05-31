package com.example.smartbites.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartbites.*
import com.example.smartbites.ui.viewmodel.AuthViewModel
import com.example.smartbites.ui.viewmodel.DashboardViewModel
import com.example.smartbites.ui.viewmodel.StatsViewModel
import com.example.smartbites.ui.viewmodel.UserSetupViewModel
import com.example.smartbites.ui.viewmodel.WaterMealViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    val authViewModel: AuthViewModel = viewModel()
    val userSetupViewModel: UserSetupViewModel = viewModel()
    val dashboardViewModel: DashboardViewModel = viewModel()
    val waterMealViewModel: WaterMealViewModel = viewModel()
    val statsViewModel: StatsViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "signup"
    ) {
        composable("signup") {
            SignUpScreen(
                darkTheme = false,
                onNavigateToLogin = { navController.navigate("login") },
                onNavigateToName = { navController.navigate("name") },
                navController = navController,
                viewModel = authViewModel
            )
        }

        composable("reset_password") {
            ResetPasswordScreen(
                darkTheme = false,
                navController = navController,
                onBackToLogin = { navController.navigate("login") },
                viewModel = authViewModel
            )
        }

        composable("name") {
            NameScreen(
                darkTheme = false,
                onNextClick = { navController.navigate("gender") },
                viewModel = userSetupViewModel
            )
        }

        composable("gender") {
            GenderScreen(
                darkTheme = false,
                onNextClick = { navController.navigate("dob") },
                viewModel = userSetupViewModel
            )
        }

        composable("dob") {
            DateOfBirthScreen(
                darkTheme = false,
                onNextClick = { navController.navigate("height") },
                viewModel = userSetupViewModel
            )
        }

        composable("height") {
            HeightScreen(
                darkTheme = false,
                navController = navController,
                viewModel = userSetupViewModel
            )
        }

        composable("weight_input_screen") {
            WeightScreen(
                darkTheme = false,
                navController = navController,
                onNextClick = { navController.navigate("target_weight") },
                viewModel = userSetupViewModel
            )
        }

        composable("target_weight") {
            TargetWeightScreen(
                darkTheme = false,
                onNextClick = { navController.navigate("goal_screen") },
                viewModel = userSetupViewModel
            )
        }

        composable("goal_screen") {
            GoalScreen(
                darkTheme = false,
                navController = navController,
                viewModel = userSetupViewModel
            )
        }

        composable("speed_screen") {
            SpeedScreen(
                navController = navController,
                darkTheme = false,
                onNextClick = { navController.navigate("smart_plan") },
                viewModel = userSetupViewModel
            )
        }

        composable("smart_plan") {
            SmartPlanScreen(
                darkTheme = false,
                onContinueClick = {
                    // ovdje ideš na HomeScreen ili slično kad korisnik završi sve
                },
                viewModel = userSetupViewModel
            )
        }
        composable("dashboard") {
            DashboardScreen(
                darkTheme = false,
                onAddMealClick = { dashboardViewModel.addMeal(500, 30, 40, 20) }, // PRIMJER
                onAddWaterClick = { dashboardViewModel.addWater(250) },
                onAddActivityClick = { dashboardViewModel.addSteps(1000) },
                navController = navController,
                viewModel = dashboardViewModel
            )
        }
        composable("addmeal") {
            AddMealScreen(
                darkTheme = false,
                navController = navController,
                viewModel = waterMealViewModel
            )
        }
        composable("addWater") {
            AddWaterScreen(
                darkTheme = false,
                navController = navController,
                viewModel = waterMealViewModel
            )
        }
        composable("mealhistory") {
            MealHistoryScreen(
                darkTheme = false,
                navController = navController,
                viewModel = waterMealViewModel
            )
        }
        composable("caloriesover") {
            CaloriesOverTimeScreen(
                darkTheme = false,
                navController = navController,
                viewModel = statsViewModel
            )
        }
        composable("weightprogress") {
            WeightProgressScreen(
                darkTheme = false,
                navController = navController,
                viewModel = statsViewModel
            )
        }
        composable("profile") {
            YourProfileScreen(
                darkTheme = false,
                viewModel = statsViewModel
            )
        }
        composable("activitylog") {
            ActivityLogScreen(
                darkTheme = false,
                navController = navController,
                viewModel = statsViewModel
            )
        }
    }
}
