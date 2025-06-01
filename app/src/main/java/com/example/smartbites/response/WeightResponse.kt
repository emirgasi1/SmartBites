package com.example.smartbites.response

data class WeightResponse(
    val id: Int,
    val userId: Int,
    val weightKg: Float,
    val date: String
)
