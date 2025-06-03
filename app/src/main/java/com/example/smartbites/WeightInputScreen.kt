package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.navigation.NavController
import com.example.smartbites.ui.viewmodel.StatsViewModel
import com.example.smartbites.ui.viewmodel.UserSetupViewModel

@Composable
fun WeightScreen(
    darkTheme: Boolean,
    navController: NavController,
    onNextClick: () -> Unit,
    viewModel: UserSetupViewModel,
    statsViewModel: StatsViewModel
) {
    val userSetupState by viewModel.userSetupState.collectAsState()
    val isValid = userSetupState.currentWeight.toFloatOrNull() != null && userSetupState.currentWeight.toFloat() > 0f

    val backgroundColor = if (darkTheme) Color(0xFF1C1C1C) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))



        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Step 5 of 9",
            color = Color(0xFFB0B0B0),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "What is your\ncurrent weight?",
            color = textColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = userSetupState.currentWeight,
            onValueChange = { viewModel.onCurrentWeightChange(it) },
            placeholder = { Text("Weight in kg", color = Color.Gray) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF3A3A3A), RoundedCornerShape(8.dp)),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 16.sp),
            colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                statsViewModel.updateWeight(userSetupState.currentWeight.toFloatOrNull() ?: 0f)
                onNextClick()
            },
            enabled = isValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00E096),
                disabledContainerColor = Color(0xFFB0B0B0)
            ),
            shape = RoundedCornerShape(24.dp)
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
