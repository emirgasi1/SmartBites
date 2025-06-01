package com.example.smartbites.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartbites.data.User
import com.example.smartbites.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSetupViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userSetupState = MutableStateFlow(UserSetupUiState())
    val userSetupState: StateFlow<UserSetupUiState> = _userSetupState

    // Čuvamo userId kojeg je napravio AuthViewModel
    private var userId: Int? = null

    fun setUserId(id: Int) {
        userId = id
    }

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

    fun onAgeChange(age: String) {
        _userSetupState.update { it.copy(age = age) }
    }

    fun onWeightChange(weight: String) {
        _userSetupState.update { it.copy(weight = weight) }
    }

    fun generateSmartPlan() {
        val calories = when (_userSetupState.value.speed) {
            "Slow" -> 2500
            "Medium" -> 2200
            "Fast" -> 2000
            else -> 2200
        }
        _userSetupState.update { it.copy(dailyCaloriesGoal = calories) }
    }

    fun saveCurrentStep() {
        val state = _userSetupState.value
        val id = userId ?: return

        viewModelScope.launch {
            val user = userRepository.getUserById(id) ?: return@launch

            val updatedUser = user.copy(
                name = state.name.ifBlank { user.name },
                age = state.age.toIntOrNull() ?: user.age,
                weight = state.weight.toFloatOrNull() ?: user.weight,
                height = state.height.toFloatOrNull() ?: user.height,
                goalType = state.goal.ifBlank { user.goalType }
            )
            userRepository.updateUser(updatedUser)
        }
    }
}

data class UserSetupUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val gender: String = "",
    val targetWeight: String = "",
    val currentWeight: String = "",
    val dateOfBirth: String = "",
    val age: String = "",
    val weight: String = "",
    val height: String = "",
    val goal: String = "",
    val speed: String = "",
    val dailyCaloriesGoal: Int = 0
)
