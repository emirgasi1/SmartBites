package com.example.smartbites.response

data class RegisterResponse(
    val userId: Int,
    val email: String,
    val name: String,
    val token: String? = null
)
