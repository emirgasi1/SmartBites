package com.example.smartbites.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao

interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(goal: Goal): Long

    @Query("SELECT * FROM goal WHERE userId = :userId")
    fun getGoalsByUser(userId: Int): Flow<List<Goal>>

    @Update
    suspend fun update(goal: Goal)

    @Delete
    suspend fun delete(goal: Goal)
    fun getAllGoals(): Flow<List<Goal>>
}
