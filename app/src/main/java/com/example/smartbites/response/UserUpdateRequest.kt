package com.example.smartbites.response

data class UserUpdateRequest(
    val userId: Int,
    val name: String?,
    val gender: String?,
    val dateOfBirth: String?,
    val heightCm: Int?,
    val weightKg: Float?
)
