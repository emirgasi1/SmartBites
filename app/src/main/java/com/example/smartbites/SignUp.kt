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
import com.example.smartbites.ui.viewmodel.AuthViewModel

@Composable
fun SignUpScreen(
    darkTheme: Boolean,
    onNavigateToLogin: () -> Unit,
    onNavigateToName: () -> Unit,
    navController: NavHostController,
    viewModel: AuthViewModel
) {
    val registerState by viewModel.registerState.collectAsState()
    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black

    LaunchedEffect(registerState.success) {
        if (registerState.success) {
            onNavigateToName()

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
        Text(
            text = "REGISTER",
            style = titleTypography.titleLarge,
            color = textColor,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = registerState.username,
            onValueChange = { viewModel.onRegisterUsernameChange(it) },
            label = { Text("Username") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors()
        )
        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = registerState.email,
            onValueChange = { viewModel.onRegisterEmailChange(it) },
            label = { Text("Email") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors()
        )
        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = registerState.password,
            onValueChange = { viewModel.onRegisterPasswordChange(it) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors()
        )
        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = registerState.confirmPassword,
            onValueChange = { viewModel.onRegisterConfirmPasswordChange(it) },
            label = { Text("Re-Use Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors()
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (registerState.error != null) {
            Text(
                text = registerState.error ?: "",
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        if (registerState.isLoading) {
            CircularProgressIndicator(
                color = Color(0xFF00C896),
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.register { newUserId ->
                    onNavigateToName()
                }
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896),
                contentColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = !registerState.isLoading
        ) {
            Text("Sign Up")
        }


        Spacer(modifier = Modifier.height(8.dp))
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

@Composable
private fun textFieldColors() = TextFieldDefaults.colors(
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
