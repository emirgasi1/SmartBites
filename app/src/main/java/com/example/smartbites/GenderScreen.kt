package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import com.example.smartbites.ui.viewmodel.UserSetupViewModel

@Composable
fun GenderScreen(
    darkTheme: Boolean,
    onNextClick: () -> Unit,
    viewModel: UserSetupViewModel
) {
    val userSetupState by viewModel.userSetupState.collectAsState()

    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black
    val greenColor = Color(0xFF00C896)
    val buttonColor = Color(0xFF3C3C3B)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Spacer(modifier = Modifier.height(12.dp))

        Text("Step 2 of 9", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "What is your gender?",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            GenderOption(
                text = "Male",
                isSelected = userSetupState.gender == "Male",
                onClick = { viewModel.onGenderChange("Male") },
                backgroundColor = buttonColor,
                greenColor = greenColor,
                width = 130.dp
            )
            GenderOption(
                text = "Female",
                isSelected = userSetupState.gender == "Female",
                onClick = { viewModel.onGenderChange("Female") },
                backgroundColor = buttonColor,
                greenColor = greenColor,
                width = 130.dp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onNextClick,
            enabled = userSetupState.gender.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = greenColor,
                disabledContainerColor = Color.Gray
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Next", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun GenderOption(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    backgroundColor: Color,
    greenColor: Color,
    width: Dp
) {
    val borderColor = if (isSelected) greenColor else Color.Transparent
    val textColor = if (isSelected) greenColor else Color.White

    Box(
        modifier = Modifier
            .width(width)
            .height(50.dp)
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .border(2.dp, borderColor, RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Medium
        )
    }
}


