package com.example.smartbites.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

// UI State koji sadrži sve potrebne podatke za 4 screena
data class StatsUiState(
    val userName: String = "User",
    val heightCm: Int = 175,
    val weightKg: Int = 78,
    val goal: String = "Lose Weight",

    val caloriesOverTime: List<Int> = listOf(
        1800, 2000, 2200, 2100, 2300, 1700, 1900
    ),                                      // Podaci za Calories Over Time Chart

    val weightProgress: List<Float> = listOf(
        80f, 79.2f, 78.5f, 77.8f
    ),                                      // Podaci za Weight Progress Chart

    val steps: Int = 7500,
    val runningMinutes: Int = 30,
    val workoutMinutes: Int = 45,

    val units: String = "Metric (kg, cm)",
    val notificationsEnabled: Boolean = true,
    val theme: String = "Dark"
)

//ViewModel koji upravlja ovim podacima
class StatsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(StatsUiState())

    val uiState: StateFlow<StatsUiState> = _uiState

    fun toggleNotifications() {
        _uiState.update { state ->
            state.copy(notificationsEnabled = !state.notificationsEnabled)
        }
    }

    fun updateTheme(newTheme: String) {
        _uiState.update { state ->
            state.copy(theme = newTheme)
        }
    }

    fun updateWeight(newWeight: Float) {
        _uiState.update { state ->
            state.copy(weightProgress = state.weightProgress + newWeight)
        }
    }

    fun updateUserInfo(name: String, height: Int, weight: Int, goal: String) {
        _uiState.update { state ->
            state.copy(
                userName = name,
                heightCm = height,
                weightKg = weight,
                goal = goal
            )
        }
    }
}
