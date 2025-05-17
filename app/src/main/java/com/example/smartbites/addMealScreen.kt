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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartbites.ui.theme.titleTypography

data class FoodItem(val name: String, val kcalPer100g: Int)

@Composable
fun AddMealScreen(darkTheme: Boolean, navController: NavHostController)
 {
    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black

    var searchQuery by remember { mutableStateOf("") }
    val foodList = listOf(
        FoodItem("Banana", 80),
        FoodItem("Banana", 80) // Dummy duplicates for demo
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    navController.navigate("dashboard") {
                        popUpTo("dashboard") { inclusive = true }
                    }
                }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Add a Meal",
            style = titleTypography.titleLarge,  // Use the custom typography h1 style
            color = textColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center // ✅ centrira tekst unutar kolone
        )


        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Search food and log what you ate",
            style = TextStyle(fontSize = 14.sp, color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(40.dp))

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
                imeAction = ImeAction.Search
            )
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Food items
        foodList.forEach { food ->
            FoodCard(food = food, darkTheme = darkTheme)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun FoodCard(food: FoodItem, darkTheme: Boolean) {
    val boxColor = Color(0xFF3C3C3B)
    val textColor = Color.White
    val accent = Color(0xFF00C896)

    var grams by remember { mutableStateOf("") }

    val calculatedKcal = grams.toIntOrNull()?.let {
        (it * food.kcalPer100g) / 100
    } ?: 0

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp) // ✅ veći box
            .background(boxColor, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                food.name,
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp // ✅ veći font
            )
            Text(
                "${food.kcalPer100g} kcal/100grams",
                color = Color.LightGray,
                fontSize = 14.sp // ✅ veći font
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = grams,
                onValueChange = { grams = it },
                modifier = Modifier
                    .width(70.dp)
                    .height(40.dp), // ✅ viši input
                singleLine = true,
                placeholder = { Text("g", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(6.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                "=$calculatedKcal kcal",
                color = accent,
                fontSize = 15.sp, // ✅ malo veće
                fontWeight = FontWeight.Medium
            )
        }
    }
}
