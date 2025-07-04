package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartbites.ui.viewmodel.StatsViewModel
import ibu.edu.ba.myapplication.R

@Composable
fun ActivityLogScreen(
    darkTheme: Boolean,
    navController: NavController,
    viewModel: StatsViewModel
) {
    val backgroundColor = if (darkTheme) Color(0xFF1C1C1C) else Color.White
    val cardColor = if (darkTheme) Color(0xFF2C2C2C) else Color(0xFFF3F3F3)
    val textColor = if (darkTheme) Color.White else Color.Black
    val uiState = viewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 16.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "Activity Log",
            color = textColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Steps, workouts, time",
            color = Color.Gray,
            fontSize = 16.sp
        )
        ActivityInfoBox(label = "Steps", value = "${uiState.steps}", cardColor = cardColor, textColor = textColor)
        Spacer(modifier = Modifier.height(18.dp))
        ActivityInfoBox(label = "Running", value = "${uiState.runningMinutes}min", cardColor = cardColor, textColor = textColor)
        Spacer(modifier = Modifier.height(18.dp))
        ActivityInfoBox(label = "Workout", value = "${uiState.workoutMinutes}min", cardColor = cardColor, textColor = textColor)

    }
}

@Composable
fun ActivityInfoBox(label: String, value: String, cardColor: Color, textColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(cardColor, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "$label: $value",
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp,
            color = textColor,
            fontWeight = FontWeight.SemiBold
        )
    }
}
