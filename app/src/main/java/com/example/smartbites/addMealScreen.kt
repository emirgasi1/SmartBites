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
import com.example.smartbites.ui.viewmodel.WaterMealViewModel

data class FoodItem(
    val name: String,
    val kcalPer100g: Int
)


@Composable
fun AddMealScreen(
    darkTheme: Boolean,
    navController: NavHostController,
    viewModel: WaterMealViewModel,
    userId: Int
) {
    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black

    var searchQuery by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    val foodList = listOf(
        FoodItem("Banana", 80),
        FoodItem("Rice", 130),
        FoodItem("Chicken", 165),
        FoodItem("Apple", 52),
        FoodItem("Oats", 389)
    )

    val filteredFoodList = foodList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Add a Meal",
            style = titleTypography.titleLarge,
            color = textColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
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

        filteredFoodList.forEach { food ->
            FoodCard(food = food, darkTheme = darkTheme, viewModel = viewModel, userId = userId)
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("mealhistory/$userId") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00C896),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("View Meal History")
        }
    }
}


@Composable
fun FoodCard(
    food: FoodItem,
    darkTheme: Boolean,
    viewModel: WaterMealViewModel,
    userId: Int
) {
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
            .height(90.dp)
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
                fontSize = 18.sp
            )
            Text(
                "${food.kcalPer100g} kcal / 100g",
                color = Color.LightGray,
                fontSize = 14.sp
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = grams,
                onValueChange = { grams = it },
                modifier = Modifier
                    .width(70.dp)
                    .height(40.dp),
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
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    if (grams.isNotEmpty() && calculatedKcal > 0) {
                        viewModel.addMeal(food.name, calculatedKcal, userId)
                        grams = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00C896),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Add")
            }
        }
    }
}
