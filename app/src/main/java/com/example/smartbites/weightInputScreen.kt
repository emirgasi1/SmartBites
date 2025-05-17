package com.example.smartbites.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartbites.R

@Composable
fun WeightScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1C))
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = R.drawable.smartbites_logo), // koristi svoj logo
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Step 5 of 9",
            color = Color(0xFFB0B0B0),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "What is your\ncurrent weight?",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Polje za unos (vizuelno, kao dizajn placeholder)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFF3A3A3A)
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = "Weight in kg", color = Color.Gray, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Next dugme
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable { navController.navigate("next_screen") }, // zamijeni kasnije rutom za step 6
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFF00E096)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "Next",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}