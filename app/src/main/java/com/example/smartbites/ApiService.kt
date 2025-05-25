package com.example.smartbites

import com.example.smartbites.LoginRequest
import com.example.smartbites.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    // Definišemo POST metodu za login
    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}