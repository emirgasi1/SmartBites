package com.example.smartbites

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartbites.ui.theme.titleTypography


@Composable
fun SignUpScreen(
    darkTheme: Boolean,
    onNavigateToLogin: () -> Unit,
    onNavigateToName: () -> Unit,  // Dodaj ovaj parametar
    navController: NavHostController
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Logo slika
        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "Logo",
            modifier = Modifier
                .size(180.dp)
                .clickable {
                    navController.navigate("dashboard") {
                        popUpTo("dashboard") { inclusive = true }
                    }
                }
        )


        Spacer(modifier = Modifier.height(16.dp))

        // Register Text
        Text(
            text = "REGISTER",
            style = titleTypography.titleLarge,  // Use the custom typography h1 style
            color = textColor, // Title color dynamically set based on theme
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Username
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Password
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Re-Use Password
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Re-Use Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Pozovi navigaciju ka NameScreen kad se klikne dugme Sign Up
                onNavigateToName()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896),
                contentColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot password
        TextButton(
            onClick = { navController.navigate("reset_password") },
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Forgot password?",
                color = Color(0xFF00C896)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Text "Don’t have an account? Register"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                color = textColor
            )
            TextButton(
                onClick = { onNavigateToLogin() },
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color(0xFF00C896)
                )
            }
        }
    }
}
