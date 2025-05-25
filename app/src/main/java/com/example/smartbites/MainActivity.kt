package com.example.smartbites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartbites.ui.theme.SmartBitesTheme
import com.example.smartbites.ui.theme.titleTypography
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            val navController = rememberNavController()

            SmartBitesTheme(darkTheme = darkTheme) {
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(
                            darkTheme = darkTheme,
                            onThemeToggle = { darkTheme = !darkTheme },
                            onNavigateToSignUp = { navController.navigate("signup") },
                            onNavigateToDashboard = {
                                navController.navigate("dashboard") {
                                    popUpTo("login") { inclusive = true }
                                }
                            },
                            navController = navController
                        )

                    }


                    composable("signup") {
                        SignUpScreen(
                            darkTheme = darkTheme,
                            onNavigateToLogin = { navController.popBackStack() },
                            onNavigateToName = { navController.navigate("name") },  // Ovdje dodaj ovu navigaciju
                            navController = navController
                        )
                    }



                    composable("dashboard") {
                        DashboardScreen(
                            darkTheme = darkTheme,
                            onAddMealClick = { navController.navigate("addmeal") },
                            onAddWaterClick = { navController.navigate("addwater") } ,
                            onAddActivityClick = { navController.navigate("activitylog") },
                            navController = navController

                        )
                    }
                    composable("addmeal") {
                        AddMealScreen(darkTheme = darkTheme, navController = navController)
                    }

                    composable("addwater") {
                        AddWaterScreen(darkTheme = darkTheme, navController = navController)
                    }
                    composable("profile") {
                        YourProfileScreen(darkTheme = darkTheme)
                    }
                    composable("activitylog") {
                        ActivityLogScreen(darkTheme = darkTheme, navController = navController)
                    }
                    composable("mealhistory") {
                        MealHistoryScreen(darkTheme = darkTheme, navController = navController)
                    }

                    composable("caloriesover") {
                        CaloriesOverTimeScreen(darkTheme = darkTheme, navController = navController)
                    }
                    composable("weightprogress") {
                        WeightProgressScreen(darkTheme = darkTheme, navController = navController)
                    }

                    composable("weightchart") {
                        WeightProgressChart(darkTheme = darkTheme)
                    }

                    composable("heightinput") {
                        HeightScreen(darkTheme = darkTheme, navController = navController)
                    }



                    composable("weight_input_screen") {
                        WeightScreen(
                            darkTheme = darkTheme,
                            onNextClick = { navController.navigate("target_weight_screen") }
                        )
                    }
                    composable("target_weight_screen") {
                        TargetWeightScreen(
                            darkTheme = darkTheme,
                            onNextClick = { navController.navigate("goal") } // sljedeći ekran
                        )
                    }
                    composable("goal") {
                        GoalScreen(
                            navController = navController,
                            darkTheme = darkTheme
                        )
                    }



                    composable("name") {
                        NameScreen(
                            darkTheme = darkTheme,
                            onNextClick = { navController.navigate("gender") }
                        )
                    }
                    composable("gender") {
                        GenderScreen(
                            darkTheme = darkTheme,
                            onNextClick = { navController.navigate("dateofbirth") }
                        )
                    }

                    composable("dateofbirth") {
                        DateOfBirthScreen(
                            darkTheme = darkTheme,
                            onNextClick = { navController.navigate("heightinput") }
                        )
                    }
                    composable("heightinput") {
                        HeightScreen(
                            darkTheme = darkTheme,
                            navController = navController
                        )
                    }

                    composable("speed_screen") {
                        SpeedScreen(
                            navController = navController,
                            darkTheme = darkTheme,
                            onNextClick = {
                                navController.navigate("smart_plan")
                            }
                        )
                    }

                    composable("smart_plan") {
                        SmartPlanScreen(
                            darkTheme = darkTheme,
                            onContinueClick = {
                                // ovdje idi na glavni ekran aplikacije, npr:
                                navController.navigate("dashboard") {
                                    popUpTo("smart_plan") { inclusive = true }
                                }
                            }
                        )
                    }
                    composable("reset_password") {
                        ResetPasswordScreen(
                            darkTheme = darkTheme,
                            navController = navController,
                            onBackToLogin = { navController.navigate("login") }
                        )
                    }

                    composable("check_inbox") {
                        CheckInboxScreen(darkTheme = darkTheme)
                    }






                }
            }
        }

    }
}

@Composable
fun LoginScreen(
    darkTheme: Boolean,
    onThemeToggle: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    onNavigateToDashboard: () -> Unit,
    navController: NavHostController
)
 {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    // Set background color based on theme
    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color(0xFF00C896) // Title text color

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Set background color for the entire screen
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo image
        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "Logo",
            modifier = Modifier
                .size(250.dp)
                .clickable {
                    navController.navigate("dashboard") {
                        popUpTo("dashboard") { inclusive = true }
                    }
                }
        )


        // "LOG IN" text with custom typography
        Text(
            text = "LOG IN",
            style = titleTypography.titleLarge,  // Use the custom typography h1 style
            color = textColor, // Title color dynamically set based on theme
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))

        // Email TextField with rounded corners and color changes based on theme
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage.isNotEmpty(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),   // tamno siva
                unfocusedContainerColor = Color(0xFF3C3C3B), // tamno siva
                errorContainerColor = Color(0xFF3C3C3B),     // tamno siva
                focusedTextColor = Color.White,              // bijeli tekst
                unfocusedTextColor = Color.White,            // bijeli tekst
                errorTextColor = Color.White,                // bijeli tekst
                focusedLabelColor = Color.White,             // bijela labela
                unfocusedLabelColor = Color.White,           // bijela labela
                errorLabelColor = Color.White,               // bijela labela
                cursorColor = Color.White,                   // bijeli cursor
                focusedIndicatorColor = Color.Transparent,   // bez donje linije
                unfocusedIndicatorColor = Color.Transparent, // bez donje linije
                errorIndicatorColor = Color.Transparent      // bez donje linije
            )
        )


        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            isError = errorMessage.isNotEmpty(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),   // tamno siva
                unfocusedContainerColor = Color(0xFF3C3C3B), // tamno siva
                errorContainerColor = Color(0xFF3C3C3B),     // tamno siva
                focusedTextColor = Color.White,              // bijeli tekst
                unfocusedTextColor = Color.White,            // bijeli tekst
                errorTextColor = Color.White,                // bijeli tekst
                focusedLabelColor = Color.White,             // bijela labela
                unfocusedLabelColor = Color.White,           // bijela labela
                errorLabelColor = Color.White,               // bijela labela
                cursorColor = Color.White,                   // bijeli cursor
                focusedIndicatorColor = Color.Transparent,   // bez donje linije
                unfocusedIndicatorColor = Color.Transparent, // bez donje linije
                errorIndicatorColor = Color.Transparent      // bez donje linije
            )
        )



        Spacer(modifier = Modifier.height(16.dp))

        // Display error message if needed
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (email.isBlank() || password.isBlank()) {
                    errorMessage = "Email or password cannot be empty"
                } else {
                    errorMessage = ""
                    onNavigateToDashboard() // ⬅️ idi na dashboard!
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896), // zelena boja #00C896
                contentColor = Color.White          // bijela boja teksta
            )
        ) {
            Text("Login")
        }
// "Forgot password?" clickable text
        TextButton(
            onClick = { navController.navigate("reset_password") },
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Forgot password?",
                color = Color(0xFF00C896)
            )
        }


// "Don’t have an account? Register" clickable text
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don’t have an account?",
                color = if (darkTheme) Color.White else Color.Black
            )
            TextButton(
                onClick = { onNavigateToSignUp() },
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Register", color = Color(0xFF00C896))
            }
        }


        // Toggle Dark/Light Mode button
        Button(
            onClick = { onThemeToggle() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896), // zelena boja #00C896
                contentColor = Color.White          // bijela boja teksta
            )
        ) {
            Text("Toggle Dark/Light Mode")
        }

    }
}



@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    SmartBitesTheme(darkTheme = true) {
        LoginScreen(
            darkTheme = true,
            onThemeToggle = {},
            onNavigateToSignUp = {},
            onNavigateToDashboard = {}, // ✅ dodaj ovo
            navController = rememberNavController() // samo za preview
        )
    }
}
