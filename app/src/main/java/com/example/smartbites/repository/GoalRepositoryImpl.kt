package com.example.smartbites.repository

import com.example.smartbites.data.Goal
import com.example.smartbites.data.GoalDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoalRepositoryImpl @Inject constructor(
    private val goalDao: GoalDao
) : GoalRepository {
    override suspend fun insertGoal(goal: Goal): Long = goalDao.insert(goal)
    override suspend fun getAllGoals(): List<Goal> = goalDao.getAllGoals() // Promjena ovdje!
    override suspend fun updateGoal(goal: Goal) = goalDao.update(goal)
    override suspend fun deleteGoal(goal: Goal) = goalDao.delete(goal)
}
