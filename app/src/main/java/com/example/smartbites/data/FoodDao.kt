package com.example.smartbites.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food: Food): Long

    @Query("SELECT * FROM food")
    fun getAllFoods(): Flow<List<Food>>

    @Update
    suspend fun update(food: Food)

    @Delete
    suspend fun delete(food: Food)
}

