package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MealHistoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1C))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            contentScale = ContentScale.Fit
        )

        // Title
        Text(
            text = "Your Meal History",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Scroll through your logged meals",
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 24.dp),
            textAlign = TextAlign.Center
        )

        // Search bar
        OutlinedTextField(
            value = TextFieldValue(""),
            onValueChange = {},
            placeholder = { Text("Search for food", color = Color.Gray) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.DarkGray,
                focusedBorderColor = Color.LightGray,
                unfocusedContainerColor = Color(0xFF2C2C2C),
                focusedContainerColor = Color(0xFF2C2C2C)
            )
        )

        // Date heading
        Text(
            text = "March 31",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 8.dp)
        )

        MealEntryItem(food = "Banana", kcal = "-134 kcal")
        MealEntryItem(food = "Banana", kcal = "-134 kcal")
    }
}

@Composable
fun MealEntryItem(food: String, kcal: String) {
    Surface(
        color = Color(0xFF2C2C2C),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = food, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(text = kcal, color = Color.White, fontSize = 16.sp)
            Text(text = "Edit", color = Color(0xFF00FFBF), fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}
