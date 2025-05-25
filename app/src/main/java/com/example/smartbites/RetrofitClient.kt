package com.example.smartbites
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// URL do API servera
const val BASE_URL = "https://your-api-url.com/"

// Retrofit instanca
object RetrofitClient {
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Postavljamo osnovnu URL adresu
            .addConverterFactory(GsonConverterFactory.create()) // Konvertujemo JSON u Kotlin objekte
            .build()
            .create(ApiService::class.java) // Kreiramo interfejs
    }
}

