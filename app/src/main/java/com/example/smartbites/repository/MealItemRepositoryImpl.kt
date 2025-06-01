package com.example.smartbites.repository

import com.example.smartbites.data.MealItem
import com.example.smartbites.data.MealItemDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealItemRepositoryImpl @Inject constructor(
    private val mealItemDao: MealItemDao
) : MealItemRepository {

    override suspend fun insertMealItem(mealItem: MealItem): Long {
        return mealItemDao.insert(mealItem)
    }

    override fun getAllMealItems(): Flow<List<MealItem>> =
        mealItemDao.getAllMealItems()

    override fun getMealItemsForMeal(mealId: Int): Flow<List<MealItem>> =
        mealItemDao.getMealItemsForMeal(mealId)

    override suspend fun updateMealItem(mealItem: MealItem) {
        mealItemDao.update(mealItem)
    }

    override suspend fun deleteMealItem(mealItem: MealItem) {
        mealItemDao.delete(mealItem)
    }
}

