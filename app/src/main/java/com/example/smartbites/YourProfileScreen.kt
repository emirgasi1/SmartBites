package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartbites.ui.viewmodel.StatsViewModel

@Composable
fun YourProfileScreen(darkTheme: Boolean,
                      viewModel: StatsViewModel
) {
    val uiState = viewModel.uiState.collectAsState().value
    val colors = MaterialTheme.colorScheme
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(top = 16.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "App Logo",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Your Profile",
            color = colors.onBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Your Personal details",
            color = colors.onBackground.copy(alpha = 0.7f),
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        ProfileInfoBox(label = "Name", value = uiState.userName)
        ProfileInfoBox(label = "Height", value = "${uiState.heightCm}cm")
        ProfileInfoBox(label = "Weight", value = "${uiState.weightKg}kg")
        ProfileInfoBox(label = "Goal", value = uiState.goal)
    }
}

@Composable
fun ProfileInfoBox(label: String, value: String) {
    val colors = MaterialTheme.colorScheme
    Surface(
        color = colors.surface,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "$label: $value",
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp,
            color = colors.onSurface,
            fontWeight = FontWeight.SemiBold
        )
    }
}
