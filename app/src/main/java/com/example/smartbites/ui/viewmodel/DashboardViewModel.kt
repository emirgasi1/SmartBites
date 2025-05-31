package com.example.smartbites.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

// UI State za Dashboard
data class DashboardUiState(
    val dailyCalories: Int = 2250,
    val consumedCalories: Int = 1230,
    val waterIntakeMl: Int = 1250,
    val steps: Int = 3200,
    val protein: Int = 70,
    val carbs: Int = 130,
    val fats: Int = 45
)

// ViewModel za Dashboard
class DashboardViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState

    fun addMeal(calories: Int, protein: Int, carbs: Int, fats: Int) {
        _uiState.update { state ->
            state.copy(
                consumedCalories = state.consumedCalories + calories,
                protein = state.protein + protein,
                carbs = state.carbs + carbs,
                fats = state.fats + fats
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

    fun addSteps(steps: Int) {
        _uiState.update { state ->
            state.copy(
                steps = state.steps + steps
            )
        }
    }
}
