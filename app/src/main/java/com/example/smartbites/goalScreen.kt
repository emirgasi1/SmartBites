package com.example.smartbites

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.example.smartbites.ui.viewmodel.UserSetupViewModel

@Composable
fun GoalScreen(
    darkTheme: Boolean,
    navController: NavController,
    viewModel: UserSetupViewModel
) {
    val userSetupState by viewModel.userSetupState.collectAsState()

    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black
    val boxSelectedColor = Color(0xFF00C896)
    val boxUnselectedColor = if (darkTheme) Color(0xFF2C2C2C) else Color(0xFFEFEFEF)
    val buttonColor = Color(0xFF00C896)
    val buttonTextColor = Color.Black

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
            text = "Step 7 of 9",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "What is your goal?",
            color = textColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            GoalOption(
                title = "Lose Weight",
                isSelected = userSetupState.goal == "lose",
                onClick = { viewModel.onGoalChange("lose") },
                selectedColor = boxSelectedColor,
                unselectedColor = boxUnselectedColor,
                textColor = if (userSetupState.goal == "lose") buttonTextColor else textColor,
                modifier = Modifier.weight(1f)
            )
            GoalOption(
                title = "Maintain Weight",
                isSelected = userSetupState.goal == "maintain",
                onClick = { viewModel.onGoalChange("maintain") },
                selectedColor = boxSelectedColor,
                unselectedColor = boxUnselectedColor,
                textColor = if (userSetupState.goal == "maintain") buttonTextColor else textColor,
                modifier = Modifier.weight(1f)
            )
            GoalOption(
                title = "Gain Weight",
                isSelected = userSetupState.goal == "gain",
                onClick = { viewModel.onGoalChange("gain") },
                selectedColor = boxSelectedColor,
                unselectedColor = boxUnselectedColor,
                textColor = if (userSetupState.goal == "gain") buttonTextColor else textColor,
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
                .background(
                    if (userSetupState.goal.isNotEmpty()) buttonColor else Color.Gray
                )
                .clickable(enabled = userSetupState.goal.isNotEmpty()) {
                    navController.navigate("speed_screen")
                }
        ) {
            Text(
                text = "Next",
                color = buttonTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun GoalOption(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedColor: Color,
    unselectedColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) selectedColor else unselectedColor)
            .clickable { onClick() }
            .padding(horizontal = 4.dp)
    ) {
        Text(
            text = title,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}