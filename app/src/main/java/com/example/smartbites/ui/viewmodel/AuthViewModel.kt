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
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginUiState())
    val loginState: StateFlow<LoginUiState> = _loginState

    private val _registerState = MutableStateFlow(RegisterUiState())
    val registerState: StateFlow<RegisterUiState> = _registerState

    private val _resetPasswordState = MutableStateFlow(ResetPasswordUiState())
    val resetPasswordState: StateFlow<ResetPasswordUiState> = _resetPasswordState

    fun onLoginEmailChange(email: String) = _loginState.update { it.copy(email = email) }
    fun onLoginPasswordChange(password: String) = _loginState.update { it.copy(password = password) }
    fun onRegisterUsernameChange(username: String) = _registerState.update { it.copy(username = username) }
    fun onRegisterEmailChange(email: String) = _registerState.update { it.copy(email = email) }
    fun onRegisterPasswordChange(password: String) = _registerState.update { it.copy(password = password) }
    fun onRegisterConfirmPasswordChange(confirmPassword: String) = _registerState.update { it.copy(confirmPassword = confirmPassword) }
    fun onResetPasswordEmailChange(email: String) = _resetPasswordState.update { it.copy(email = email) }

    fun login() {
        val email = _loginState.value.email
        val password = _loginState.value.password
        _loginState.update { it.copy(isLoading = true, error = null, success = false) }
        viewModelScope.launch {
            val user = userRepository.getUserByEmailAndPassword(email, password)
            if (user != null) {
                _loginState.update { it.copy(isLoading = false, error = null, success = true) }
            } else {
                _loginState.update { it.copy(isLoading = false, error = "User not found", success = false) }
            }
        }
    }

    fun register(onSuccess: (Int) -> Unit = {}) {
        val username = _registerState.value.username
        val email = _registerState.value.email
        val password = _registerState.value.password
        val confirmPassword = _registerState.value.confirmPassword

        if (password != confirmPassword) {
            _registerState.update { it.copy(error = "Passwords do not match") }
            return
        }
        _registerState.update { it.copy(isLoading = true, error = null, success = false) }

        viewModelScope.launch {
            try {
                val user = User(
                    name = username,
                    email = email,
                    password = password,
                    age = 0,
                    weight = 0f,
                    height = 0f,
                    goalType = ""
                )
                val userId = userRepository.insertUser(user).toInt()
                _registerState.update { it.copy(isLoading = false, error = null, success = true) }
                onSuccess(userId)
            } catch (e: Exception) {
                _registerState.update { it.copy(isLoading = false, error = e.message, success = false) }
            }
        }
    }
}
// UI State klase
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

data class RegisterUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

data class ResetPasswordUiState(
    val email: String = ""
)
