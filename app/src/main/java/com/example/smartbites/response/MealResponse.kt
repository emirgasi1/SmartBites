package com.example.smartbites.response

data class MealResponse(
    val id: Int,
    val userId: Int,
    val mealType: String,
    val mealTime: String,
    val totalCalories: Int
)
