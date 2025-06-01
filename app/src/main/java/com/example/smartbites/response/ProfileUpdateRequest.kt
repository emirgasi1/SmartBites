package com.example.smartbites.response

data class ProfileUpdateRequest(
    val userId: Int,
    val name: String,
    val heightCm: Int,
    val weightKg: Float,
    val goal: String,
    val gender: String?,
    val dateOfBirth: String?
)
