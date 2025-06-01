package com.example.smartbites.repository

import com.example.smartbites.data.Food
import com.example.smartbites.data.FoodDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDao: FoodDao
) : FoodRepository {
    override suspend fun insertFood(food: Food): Long = foodDao.insert(food)
    override fun getAllFoods(): Flow<List<Food>> = foodDao.getAllFoods()
    override suspend fun updateFood(food: Food) = foodDao.update(food)
    override suspend fun deleteFood(food: Food) = foodDao.delete(food)
}
