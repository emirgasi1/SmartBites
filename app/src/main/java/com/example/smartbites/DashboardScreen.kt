package com.example.smartbites

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen(darkTheme: Boolean, onAddMealClick: () -> Unit,    onAddWaterClick: () -> Unit
) {
    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black
    val borderColor = Color(0xFF00C896)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // ⬅️ dodano
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "Logo",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Good morning, User",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        )

        Text(
            text = "Here's your daily overview",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Calorie circle
        Box(
            modifier = Modifier
                .size(180.dp)
                .border(5.dp, borderColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "1230/2250\nkcal",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (darkTheme) Color.White else Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Add buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            DashboardButton("Add Meal", Modifier.weight(1f), onClick = onAddMealClick)
            DashboardButton("Add Water", modifier = Modifier.weight(1f), onClick = onAddWaterClick)
            DashboardButton("Add Activity", Modifier.weight(1f), onClick = { /* TODO */ })
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Info fields
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InfoBox("Water: 1250ml")
            InfoBox("Steps: 3,200")
            InfoBox("Protein: 70g")
            InfoBox("Carbs: 130g")
            InfoBox("Fats: 45g")
        }
    }
}

@Composable
fun DashboardButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color(0xFF00C896)
        ),
        border = BorderStroke(1.dp, Color(0xFF00C896)),
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = text,
                fontSize = 12.sp,
                maxLines = 2,
                softWrap = true,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun InfoBox(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3C3C3B), shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}
