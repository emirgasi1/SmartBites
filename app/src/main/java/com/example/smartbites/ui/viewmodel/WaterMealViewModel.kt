package com.example.smartbites.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartbites.data.Meal
import com.example.smartbites.repository.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

// UI State klasa
data class MealUI(
    val name: String,
    val calories: Int
)

data class WaterMealUiState(
    val waterIntakeMl: Int = 0,
    val mealHistory: List<MealUI> = emptyList()
)

// Mapper funkcije
fun Meal.toMealUI(): MealUI {
    return MealUI(
        name = this.mealType,
        calories = this.totalCalories
    )
}

fun MealUI.toMealEntity(userId: Int): Meal {
    return Meal(
        userId = userId,
        mealTime = "Lunch",
        mealType = this.name,
        totalCalories = this.calories
    )
}

// ViewModel
@HiltViewModel
class WaterMealViewModel @Inject constructor(
    private val mealRepository: MealRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WaterMealUiState())
    val uiState: StateFlow<WaterMealUiState> = _uiState.asStateFlow()

    fun loadMeals(userId: Int) {
        viewModelScope.launch {
            mealRepository.getMealsByUser(userId)
                .map { meals -> meals.map { it.toMealUI() } } // Room Meal ➔ MealUI
                .collect { mealUIList ->
                    _uiState.update { state ->
                        state.copy(mealHistory = mealUIList)
                    }
                }
        }
    }

    fun addMeal(name: String, calories: Int, userId: Int) {
        viewModelScope.launch {
            val meal = Meal(
                userId = userId,
                mealTime = "Lunch",
                mealType = name,
                totalCalories = calories
            )
            mealRepository.insertMeal(meal)
            // reload
            loadMeals(userId)
        }
    }

    fun deleteMeal(meal: MealUI, userId: Int) {
        viewModelScope.launch {
            mealRepository.deleteMeal(meal.toMealEntity(userId))
            // reload
            loadMeals(userId)
        }
    }

    fun addWater(amountMl: Int) {
        _uiState.update { state ->
            state.copy(
                waterIntakeMl = state.waterIntakeMl + amountMl
            )
        }
    }
}


