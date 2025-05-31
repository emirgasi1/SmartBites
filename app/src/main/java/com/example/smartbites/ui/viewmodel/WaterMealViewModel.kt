package com.example.smartbites.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

//UI State klasa
data class Meal(
    val name: String,
    val calories: Int
)

data class WaterMealUiState(
    val waterIntakeMl: Int = 0,
    val mealHistory: List<Meal> = emptyList()
)

//ViewModel
class WaterMealViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(WaterMealUiState())
    val uiState: StateFlow<WaterMealUiState> = _uiState

    fun addMeal(name: String, calories: Int) {
        _uiState.update { state ->
            state.copy(
                mealHistory = state.mealHistory + Meal(name, calories)
            )
        }
    }

    fun addWater(amountMl: Int) {
        _uiState.update { state ->
            state.copy(
                waterIntakeMl = state.waterIntakeMl + amountMl
            )
        }
    }

    fun deleteMeal(meal: Meal) {
        _uiState.update { state ->
            state.copy(
                mealHistory = state.mealHistory - meal
            )
        }
    }
}
