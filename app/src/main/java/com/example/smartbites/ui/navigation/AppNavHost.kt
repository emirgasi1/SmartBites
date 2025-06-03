package com.example.smartbites.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
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
fun AppNavHost(navController: NavHostController, darkTheme: Boolean) {

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            val authViewModel: AuthViewModel = hiltViewModel()
            LoginScreen(
                darkTheme = darkTheme,
                onThemeToggle = { /* ... */ },
                onNavigateToSignUp = { navController.navigate("signup") },
                onNavigateToDashboard = { navController.navigate("dashboard") },
                navController = navController,
                viewModel = authViewModel
            )
        }
        composable("signup") {
            SignUpScreen(
                darkTheme = darkTheme,
                onNavigateToLogin = { navController.navigate("login") },
                onNavigateToName = { navController.navigate("name") },
                navController = navController,
                viewModel = hiltViewModel<AuthViewModel>()
            )
        }
        composable("reset_password") {
            ResetPasswordScreen(
                darkTheme = darkTheme,
                navController = navController,
                onBackToLogin = { navController.navigate("login") },
                viewModel = hiltViewModel<AuthViewModel>()
            )
        }
        composable("name") {
            NameScreen(
                darkTheme = darkTheme,
                onNextClick = { navController.navigate("gender") },
                viewModel = hiltViewModel<UserSetupViewModel>()
            )
        }
        composable("gender") {
            GenderScreen(
                darkTheme = darkTheme,
                onNextClick = { navController.navigate("dob") },
                viewModel = hiltViewModel<UserSetupViewModel>()
            )
        }
        composable("dob") {
            DateOfBirthScreen(
                darkTheme = darkTheme,
                onNextClick = { navController.navigate("height") },
                viewModel = hiltViewModel<UserSetupViewModel>()
            )
        }
        composable("height") {
            HeightScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<UserSetupViewModel>()
            )
        }
        composable("weight_input_screen") {
            WeightScreen(
                darkTheme = darkTheme,
                navController = navController,
                onNextClick = { navController.navigate("target_weight") },
                viewModel = hiltViewModel<UserSetupViewModel>(),
                statsViewModel = hiltViewModel<StatsViewModel>()
            )
        }
        composable("target_weight") {
            TargetWeightScreen(
                darkTheme = darkTheme,
                onNextClick = { navController.navigate("goal_screen") },
                viewModel = hiltViewModel<UserSetupViewModel>()
            )
        }
        composable("goal_screen") {
            GoalScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<UserSetupViewModel>()
            )
        }
        composable("speed_screen") {
            SpeedScreen(
                navController = navController,
                darkTheme = darkTheme,
                onNextClick = { navController.navigate("smart_plan") },
                viewModel = hiltViewModel<UserSetupViewModel>()
            )
        }
        composable("smart_plan") {
            SmartPlanScreen(
                darkTheme = darkTheme,
                onContinueClick = {
                    navController.navigate("dashboard") {
                        popUpTo("smart_plan") { inclusive = true }
                    }
                },
                viewModel = hiltViewModel<UserSetupViewModel>(),
                statsViewModel = hiltViewModel<StatsViewModel>()
            )
        }
        composable("dashboard") {
            val dashboardViewModel: DashboardViewModel = hiltViewModel()
            DashboardScreen(
                darkTheme = darkTheme,
                onAddMealClick = { navController.navigate("addmeal/1") },
                onAddWaterClick = { navController.navigate("addWater") },
                onAddActivityClick = { navController.navigate("activitylog") },
                navController = navController,
                viewModel = dashboardViewModel
            )
        }


        composable("addmeal/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull() ?: 1
            AddMealScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<WaterMealViewModel>(),
                userId = userId
            )
        }
        composable("addWater") {
            AddWaterScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<WaterMealViewModel>()
            )
        }
        composable("mealhistory/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull() ?: 1
            MealHistoryScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<WaterMealViewModel>(),
                userId = userId
            )
        }
        composable("caloriesover") {
            CaloriesOverTimeScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<StatsViewModel>()
            )
        }
        composable("weightprogress") {
            WeightProgressScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<StatsViewModel>()
            )
        }
        composable("profile") {
            YourProfileScreen(
                darkTheme = darkTheme,
                viewModel = hiltViewModel<StatsViewModel>()
            )
        }
        composable("activitylog") {
            ActivityLogScreen(
                darkTheme = darkTheme,
                navController = navController,
                viewModel = hiltViewModel<StatsViewModel>()
            )
        }
    }
}
