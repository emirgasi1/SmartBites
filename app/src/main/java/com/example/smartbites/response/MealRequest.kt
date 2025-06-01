package com.example.smartbites.response

data class MealRequest(
    val userId: Int,
    val mealType: String,
    val mealTime: String,
    val totalCalories: Int

)
