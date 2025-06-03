package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import com.example.smartbites.ui.viewmodel.MealUI
import com.example.smartbites.ui.viewmodel.WaterMealViewModel

@Composable
fun MealHistoryScreen(
    darkTheme: Boolean,
    navController: NavController,
    viewModel: WaterMealViewModel,
    userId: Int
) {
    val backgroundColor = if (darkTheme) Color(0xFF1C1C1C) else Color.White
    val cardColor = if (darkTheme) Color(0xFF2C2C2C) else Color(0xFFF3F3F3)
    val textColor = if (darkTheme) Color.White else Color.Black

    var search by remember { mutableStateOf(TextFieldValue("")) }
    val uiState by viewModel.uiState.collectAsState()


    val filteredMeals = uiState.mealHistory.filter {
        it.name.contains(search.text, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {




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


        if (filteredMeals.isEmpty()) {
            Text("No meals found.", color = Color.Gray)
        } else {
            filteredMeals.forEach { meal ->
                MealEntryItem(
                    meal = meal,
                    cardColor = cardColor,
                    textColor = textColor,
                    onDeleteClick = { viewModel.deleteMeal(meal, userId) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))


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
fun MealEntryItem(
    meal: MealUI,
    cardColor: Color,
    textColor: Color,
    onDeleteClick: () -> Unit
) {
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
            Column {
                Text(
                    text = meal.name,
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${meal.calories} kcal",
                    color = textColor,
                    fontSize = 14.sp
                )
            }
            Text(
                text = "Delete",
                color = Color(0xFF00E096),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { onDeleteClick() }
            )
        }
    }
}
