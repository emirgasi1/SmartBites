package com.example.smartbites.repository

import com.example.smartbites.data.Meal
import com.example.smartbites.data.MealDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealDao: MealDao
) : MealRepository {

    override suspend fun insertMeal(meal: Meal): Long {
        return mealDao.insert(meal)
    }

    override fun getMealsByUser(userId: Int): Flow<List<Meal>> {
        return mealDao.getMealsByUser(userId)
    }

    override suspend fun updateMeal(meal: Meal) {
        mealDao.update(meal)
    }

    override suspend fun deleteMeal(meal: Meal) {
        mealDao.delete(meal)
    }
}
