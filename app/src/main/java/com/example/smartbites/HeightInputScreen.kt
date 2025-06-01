package com.example.smartbites


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartbites.ui.viewmodel.UserSetupViewModel


@Composable
fun HeightScreen(
    darkTheme: Boolean,
    navController: NavController,
    viewModel: UserSetupViewModel
) {
    val userSetupState by viewModel.userSetupState.collectAsState()

    val backgroundColor = if (darkTheme) Color(0xFF1C1C1C) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black
    val inputBackgroundColor = if (darkTheme) Color(0xFF2D2D2D) else Color(0xFFEFEFEF)
    val greenColor = Color(0xFF00E096)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 32.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "Logo",
            modifier = Modifier.size(180.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Step 4 of 9", color = Color.Gray, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "How tall are you?", color = textColor, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = userSetupState.height,
            onValueChange = { viewModel.onHeightChange(it) },
            placeholder = { Text("Height in cm", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF3C3C3B),
                unfocusedContainerColor = Color(0xFF3C3C3B),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("weight_input_screen") },
            enabled = userSetupState.height.isNotEmpty(), //Ako bude sta zezalo ovo trbe izbrisat
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = greenColor)
        ) {
            Text(text = "Next", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}
