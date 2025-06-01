package com.example.smartbites.response

data class UserProfileResponse(
    val userId: Int,
    val email: String,
    val name: String,
    val gender: String,
    val dateOfBirth: String,
    val heightCm: Int,
    val weightKg: Float,
    val createdAt: String
)
