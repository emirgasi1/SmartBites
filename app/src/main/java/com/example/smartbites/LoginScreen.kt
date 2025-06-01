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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.smartbites.ui.theme.SmartBitesTheme
import com.example.smartbites.ui.theme.titleTypography
import com.example.smartbites.ui.viewmodel.AuthViewModel
import com.example.smartbites.ui.viewmodel.LoginUiState

@Composable
fun LoginScreen(
    darkTheme: Boolean,
    onThemeToggle: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    onNavigateToDashboard: () -> Unit,
    navController: NavHostController,
    viewModel: AuthViewModel
) {
    val loginState by viewModel.loginState.collectAsState()
    var errorMessage by remember { mutableStateOf("") }

    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color(0xFF00C896)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
        Text(
            text = "LOG IN",
            style = titleTypography.titleLarge,
            color = textColor,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))

        TextField(
            value = loginState.email,
            onValueChange = { viewModel.onLoginEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage.isNotEmpty(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                errorContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                errorTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                errorLabelColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = loginState.password,
            onValueChange = { viewModel.onLoginPasswordChange(it) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            isError = errorMessage.isNotEmpty(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                errorContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                errorTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                errorLabelColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (loginState.email.isBlank() || loginState.password.isBlank()) {
                    errorMessage = "Email or password cannot be empty"
                } else {
                    viewModel.login()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896),
                contentColor = Color.White
            )
        ) {
            Text("Login")
        }
        TextButton(
            onClick = { navController.navigate("reset_password") },
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Forgot password?",
                color = Color(0xFF00C896)
            )
        }
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
        Button(
            onClick = { onThemeToggle() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896),
                contentColor = Color.White
            )
        ) {
            Text("Toggle Dark/Light Mode")
        }
    }
}

@Composable
fun LoginScreenPreviewOnly(
    darkTheme: Boolean,
    loginState: LoginUiState = LoginUiState(),
    onThemeToggle: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToDashboard: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
) {
    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color(0xFF00C896)
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Ovdje možeš koristiti neki preview image ili skloniti za preview
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "LOG IN",
            style = titleTypography.titleLarge,
            color = textColor,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))

        TextField(
            value = loginState.email,
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage.isNotEmpty(),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = loginState.password,
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) { Text("Login") }
        TextButton(
            onClick = {},
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Forgot password?",
                color = Color(0xFF00C896)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don’t have an account?",
                color = if (darkTheme) Color.White else Color.Black
            )
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Register", color = Color(0xFF00C896))
            }
        }
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Toggle Dark/Light Mode")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    SmartBitesTheme(darkTheme = true) {
        LoginScreenPreviewOnly(
            darkTheme = true,
            loginState = LoginUiState(
                email = "preview@email.com",
                password = "1234"
            )
        )
    }
}
