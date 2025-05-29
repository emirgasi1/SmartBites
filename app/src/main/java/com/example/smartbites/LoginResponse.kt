package com.example.smartbites

data class LoginResponse(
    val token: String,  // JWT token koji dobijemo nakon uspešnog login-a
    val userId: String  // ID korisnika, ako je potrebno
)