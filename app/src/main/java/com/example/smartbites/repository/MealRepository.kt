package com.example.smartbites.repository

import com.example.smartbites.data.Meal
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun insertMeal(meal: Meal): Long
    fun getMealsByUser(userId: Int): Flow<List<Meal>>
    suspend fun updateMeal(meal: Meal)
    suspend fun deleteMeal(meal: Meal)
}
