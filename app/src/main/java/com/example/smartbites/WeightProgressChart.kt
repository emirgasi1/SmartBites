package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.entry.entryModelOf

@Composable
fun WeightProgressChart() {
    val model = entryModelOf(80.0f, 79.0f, 78.5f, 77.8f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1C))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // LOGO
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "SmartBites Logo",
            modifier = Modifier
                .height(150.dp)
                .padding(bottom = 8.dp),
            contentScale = ContentScale.Fit
        )

        // Naslov
        Text(
            text = "Weight Progress",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Podnaslov
        Text(
            text = "Visualize your weight trend",
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Grafikon
        Chart(
            chart = lineChart(),
            model = model,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
    }
}
