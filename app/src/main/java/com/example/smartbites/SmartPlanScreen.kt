package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController
import com.example.smartbites.R

@Composable
fun SmartPlanScreen(
    darkTheme: Boolean,
    onContinueClick: () -> Unit,
    dailyCalories: String = "2,250 kcal",
    goal: String = "Lose Weight (Fast)",
    currentWeight: String = "78 kg",
    targetWeight: String = "70kg"
) {
    // Theme-based colors
    val backgroundColor = if (darkTheme) Color(0xFF232323) else Color.White
    val accentColor = Color(0xFF00E096)
    val cardColor = if (darkTheme) Color(0xFF3A3A3A) else Color(0xFFF3F3F3)
    val mainTextColor = if (darkTheme) Color.White else Color.Black
    val secondaryTextColor = if (darkTheme) Color.Gray else Color.DarkGray

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "SmartBites Logo",
            modifier = Modifier
                .height(110.dp)
                .padding(bottom = 8.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Step 9 of 9",
            color = secondaryTextColor,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Text(
            text = "Your Smart Plan is Ready!",
            color = mainTextColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 22.dp)
        )

        // Info box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(cardColor)
                .padding(18.dp)
        ) {
            Column {
                Text(
                    text = "Daily Calorie Goal: $dailyCalories",
                    color = mainTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Target: $goal",
                    color = mainTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Current Weight: $currentWeight",
                    color = mainTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Target Weight: $targetWeight",
                    color = mainTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Continue to app button
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(accentColor)
                .clickable { onContinueClick() }
        ) {
            Text(
                text = "Continue to app",
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
