package com.example.smartbites.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MealItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mealItem: MealItem): Long

    @Query("SELECT * FROM meal_item WHERE mealId = :mealId")
    fun getMealItemsForMeal(mealId: Int): Flow<List<MealItem>>

    @Query("SELECT * FROM meal_item")
    fun getAllMealItems(): Flow<List<MealItem>>

    @Update
    suspend fun update(mealItem: MealItem): Int

    @Delete
    suspend fun delete(mealItem: MealItem)
}

