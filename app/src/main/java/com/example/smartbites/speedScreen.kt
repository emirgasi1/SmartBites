package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController

@Composable
fun SpeedScreen(
    navController: NavController,
    darkTheme: Boolean,
    onNextClick: () -> Unit
) {
    var selectedSpeed by remember { mutableStateOf("") }
    val backgroundColor = if (darkTheme) Color(0xFF1C1C1C) else Color.White
    val accent = Color(0xFF00E096)
    val boxColor = if (darkTheme) Color(0xFF3A3A3A) else Color(0xFFEFEFEF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Step 8 of 9",
            color = Color(0xFFB0B0B0),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "How fast do you want to\nreach your goal?",
            color = if (darkTheme) Color.White else Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            SpeedOption(
                title = "Slow",
                isSelected = selectedSpeed == "Slow",
                onClick = { selectedSpeed = "Slow" },
                darkTheme = darkTheme,
                modifier = Modifier.weight(1f)
            )
            SpeedOption(
                title = "Medium",
                isSelected = selectedSpeed == "Medium",
                onClick = { selectedSpeed = "Medium" },
                darkTheme = darkTheme,
                modifier = Modifier.weight(1f)
            )
            SpeedOption(
                title = "Fast",
                isSelected = selectedSpeed == "Fast",
                onClick = { selectedSpeed = "Fast" },
                darkTheme = darkTheme,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(accent)
                .clickable(
                    enabled = selectedSpeed.isNotBlank(),
                    onClick = onNextClick
                )
        ) {
            Text(
                text = "Next",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SpeedOption(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    darkTheme: Boolean,
    modifier: Modifier = Modifier // <--- OVO KORISTI!
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier // Ovdje koristi parametar!
            .height(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSelected) Color(0xFF00E096)
                else if (darkTheme) Color(0xFF3A3A3A)
                else Color(0xFFEFEFEF)
            )
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            color = if (isSelected) Color.Black else if (darkTheme) Color.White else Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
