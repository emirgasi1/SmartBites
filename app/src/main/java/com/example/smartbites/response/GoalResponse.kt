package com.example.smartbites.response

data class GoalResponse(
    val id: Int,
    val userId: Int,
    val type: String,
    val targetWeight: Float,
    val dailyCalories: Int
)
