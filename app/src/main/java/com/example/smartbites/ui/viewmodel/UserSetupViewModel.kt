package com.example.smartbites.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UserSetupViewModel : ViewModel() {

    private val _userSetupState = MutableStateFlow(UserSetupUiState())
    val userSetupState: StateFlow<UserSetupUiState> = _userSetupState

    fun onNameChange(name: String) {
        _userSetupState.update { it.copy(name = name) }
    }

    fun onGenderChange(gender: String) {
        _userSetupState.update { it.copy(gender = gender) }
    }

    fun onDateOfBirthChange(dateOfBirth: String) {
        _userSetupState.update { it.copy(dateOfBirth = dateOfBirth) }
    }

    fun onHeightChange(height: String) {
        _userSetupState.update { it.copy(height = height) }
    }

    fun onCurrentWeightChange(currentWeight: String) {
        _userSetupState.update { it.copy(currentWeight = currentWeight) }
    }

    fun onTargetWeightChange(targetWeight: String) {
        _userSetupState.update { it.copy(targetWeight = targetWeight) }
    }

    fun onGoalChange(goal: String) {
        _userSetupState.update { it.copy(goal = goal) }
    }

    fun onSpeedChange(speed: String) {
        _userSetupState.update { it.copy(speed = speed) }
    }

    fun generateSmartPlan() {
        // TODO: Ovdje treba ubaciti neku logiku da izračunaš plan
    }
}

// UI State klasa
data class UserSetupUiState(
    val name: String = "",
    val gender: String = "",
    val dateOfBirth: String = "",
    val height: String = "",
    val currentWeight: String = "",
    val targetWeight: String = "",
    val goal: String = "",
    val speed: String = ""
)
