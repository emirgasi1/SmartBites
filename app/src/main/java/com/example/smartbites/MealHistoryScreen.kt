package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import androidx.navigation.NavController

@Composable
fun MealHistoryScreen(
    darkTheme: Boolean,
    navController: NavController
) {
    val backgroundColor = if (darkTheme) Color(0xFF1C1C1C) else Color.White
    val cardColor = if (darkTheme) Color(0xFF2C2C2C) else Color(0xFFF3F3F3)
    val textColor = if (darkTheme) Color.White else Color.Black

    var search by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "App Logo",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            contentScale = ContentScale.Fit
        )

        // Title
        Text(
            text = "Your Meal History",
            color = textColor,
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
            value = search,
            onValueChange = { search = it },
            placeholder = { Text("Search for food", color = Color.Gray) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .background(cardColor, RoundedCornerShape(10.dp)),
            textStyle = androidx.compose.ui.text.TextStyle(color = textColor, fontSize = 16.sp)
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

        MealEntryItem(food = "Banana", kcal = "-134 kcal", cardColor = cardColor, textColor = textColor)
        MealEntryItem(food = "Apple", kcal = "-95 kcal", cardColor = cardColor, textColor = textColor)
        MealEntryItem(food = "Rice", kcal = "-200 kcal", cardColor = cardColor, textColor = textColor)
        Spacer(modifier = Modifier.height(32.dp))

        // Prvi button: Weight Progress Chart
        Button(
            onClick = { navController.navigate("weightprogress") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00E096),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Text("Weight Progress Chart")
        }

        // Drugi button: Calories Over Time
        Button(
            onClick = { navController.navigate("caloriesover") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Calories Over Time")
        }
    }
}

@Composable
fun MealEntryItem(food: String, kcal: String, cardColor: Color, textColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(cardColor, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = food, color = textColor, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(text = kcal, color = textColor, fontSize = 16.sp)
            Text(text = "Edit", color = Color(0xFF00E096), fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}
