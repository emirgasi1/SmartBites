package com.example.smartbites.response

data class WeightRequest(
    val userId: Int,
    val weightKg: Float,
    val date: String
)
