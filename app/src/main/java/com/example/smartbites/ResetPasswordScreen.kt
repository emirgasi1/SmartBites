package com.example.smartbites

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartbites.ui.viewmodel.AuthViewModel

@Composable
fun ResetPasswordScreen(
    darkTheme: Boolean,
    navController: NavController,
    onBackToLogin: () -> Unit,
    viewModel: AuthViewModel
) {
    val resetPasswordState by viewModel.resetPasswordState.collectAsState()

    val email = resetPasswordState.email
    val isValid = email.contains("@") && email.contains(".")

    val backgroundColor = if (darkTheme) Color(0xFF1C1C1C) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Reset Password",
            color = textColor,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Text(
            text = "Enter your email to receive reset instructions.",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 28.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.onResetPasswordEmailChange(it) },
            placeholder = { Text("Email") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF3A3A3A), RoundedCornerShape(10.dp)),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 16.sp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("check_inbox")
            },
            enabled = isValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00E096),
                disabledContainerColor = Color.Gray
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "Send Reset Link",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }



        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Back to Login",
            color = Color(0xFF00E096),
            fontSize = 15.sp,
            modifier = Modifier
                .clickable { onBackToLogin() }
                .padding(top = 8.dp)
        )
    }
}
