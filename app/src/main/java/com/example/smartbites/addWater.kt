package com.example.smartbites

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartbites.ui.theme.titleTypography

@Composable
fun AddWaterScreen(darkTheme: Boolean,  navController: NavHostController) {
    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black
    val accent = Color(0xFF00C896)

    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Logo
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

        // Title
        Text(
            text = "Track Your Water Intake",
            style = titleTypography.titleLarge,  // Use the custom typography h1 style
            color = textColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center // ✅ centrira tekst unutar kolone
        )


        Spacer(modifier = Modifier.height(4.dp))

        // Subtitle
        Text(
            text = "Stay hydrated",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WaterAmountButton("+250ml", modifier = Modifier.padding(end = 16.dp))
            WaterAmountButton("+500ml", modifier = Modifier.padding(start = 16.dp))
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Search bar (optional placeholder)
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search for food", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF3C3C3B), shape = RoundedCornerShape(12.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(36.dp))

        // Confirm Button
        Button(
            onClick = { /* TODO: Save water intake */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = accent,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(200.dp) // ✅ fiksna širina
                .height(48.dp)
        ) {
            Text("I drank it")
        }
    }
}

@Composable
fun WaterAmountButton(label: String, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { /* TODO: handle selection */ },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color(0xFF00C896)
        ),
        border = BorderStroke(1.dp, Color(0xFF00C896)),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .height(42.dp)
    ) {
        Text(text = label, fontSize = 14.sp)
    }
}

