package com.example.smartbites.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel : ViewModel() {

    private val _loginState = MutableStateFlow(LoginUiState())
    val loginState: StateFlow<LoginUiState> = _loginState

    private val _registerState = MutableStateFlow(RegisterUiState())
    val registerState: StateFlow<RegisterUiState> = _registerState

    private val _resetPasswordState = MutableStateFlow(ResetPasswordUiState())
    val resetPasswordState: StateFlow<ResetPasswordUiState> = _resetPasswordState

    fun onLoginEmailChange(email: String) {
        _loginState.update { it.copy(email = email) }
    }

    fun onLoginPasswordChange(password: String) {
        _loginState.update { it.copy(password = password) }
    }

    fun onRegisterUsernameChange(username: String) {
        _registerState.update { it.copy(username = username) }
    }

    fun onRegisterEmailChange(email: String) {
        _registerState.update { it.copy(email = email) }
    }

    fun onRegisterPasswordChange(password: String) {
        _registerState.update { it.copy(password = password) }
    }

    fun onRegisterConfirmPasswordChange(confirmPassword: String) {
        _registerState.update { it.copy(confirmPassword = confirmPassword) }
    }

    fun onResetPasswordEmailChange(email: String) {
        _resetPasswordState.update { it.copy(email = email) }
    }

    fun login() {
        // TODO: Implement login API call
    }

    fun register() {
        // TODO: Implement register API call
    }

    fun resetPassword() {
        // TODO: Implement reset password API call
    }
}

// UI State klase
data class LoginUiState(
    val email: String = "",
    val password: String = ""
)

data class RegisterUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)

data class ResetPasswordUiState(
    val email: String = ""
)
