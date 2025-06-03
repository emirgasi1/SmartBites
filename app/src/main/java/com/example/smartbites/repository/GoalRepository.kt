package com.example.smartbites.repository

import com.example.smartbites.data.Goal
import kotlinx.coroutines.flow.Flow

interface GoalRepository {
    suspend fun insertGoal(goal: Goal): Long
    suspend fun getAllGoals(): List<Goal>      // <- OVO PROMIJENI u suspend
    suspend fun updateGoal(goal: Goal)
    suspend fun deleteGoal(goal: Goal)
}
