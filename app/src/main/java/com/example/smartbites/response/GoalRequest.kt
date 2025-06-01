package com.example.smartbites.response

data class GoalRequest(
    val userId: Int,
    val type: String,
    val targetWeight: Float,
    val dailyCalories: Int
)
