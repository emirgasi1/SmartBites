package com.example.smartbites.repository

import com.example.smartbites.data.MealItem
import kotlinx.coroutines.flow.Flow

interface MealItemRepository {
    suspend fun insertMealItem(mealItem: MealItem): Long
    fun getAllMealItems(): Flow<List<MealItem>>
    fun getMealItemsForMeal(mealId: Int): Flow<List<MealItem>>
    suspend fun updateMealItem(mealItem: MealItem)
    suspend fun deleteMealItem(mealItem: MealItem)
}
