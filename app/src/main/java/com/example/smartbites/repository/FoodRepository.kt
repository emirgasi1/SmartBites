package com.example.smartbites.repository

import com.example.smartbites.data.Food
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    suspend fun insertFood(food: Food): Long
    fun getAllFoods(): Flow<List<Food>>
    suspend fun updateFood(food: Food)
    suspend fun deleteFood(food: Food)
}
