package com.example.smartbites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartbites.ui.theme.SmartBitesTheme

@Composable
fun NameScreen(
    darkTheme: Boolean,
    onNextClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }

    val backgroundColor = if (darkTheme) Color(0xFF282727) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black
    val greenColor = Color(0xFF00C896)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo__2_),
            contentDescription = "Logo",
            modifier = Modifier.size(140.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Step 1 of 9",
            style = TextStyle(fontSize = 14.sp, color = Color.Gray),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "What is your name?",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text("Your name") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF3C3C3B), RoundedCornerShape(10.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = greenColor,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = greenColor),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Next", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNameScreen() {
    SmartBitesTheme(darkTheme = true) {
        NameScreen(darkTheme = true, onNextClick = {})
    }
}
