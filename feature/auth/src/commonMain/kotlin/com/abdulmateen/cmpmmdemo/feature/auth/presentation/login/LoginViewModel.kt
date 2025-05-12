package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun uiAction(action: LoginUiAction) {
        when(action){
            LoginUiAction.OnLoginClicked -> { /* ToDO */ }
            is LoginUiAction.UpdateLoadingStatus -> {
                _uiState.update {
                    it.copy(
                        isLoading = action.loading
                    )
                }
            }
            is LoginUiAction.UpdatePassword -> {
                _uiState.update {
                    it.copy(
                        password = action.text
                    )
                }
            }
            is LoginUiAction.UpdatePasswordErrorStatus -> {
                _uiState.update {
                    it.copy(
                        hasPasswordError = action.hasError,
                        passwordErrorMessage = action.errorMessage
                    )
                }
            }
            is LoginUiAction.UpdateUsername -> {
                _uiState.update {
                    it.copy(
                        username = action.text
                    )
                }
            }
            is LoginUiAction.UpdateUsernameErrorStatus -> {
                _uiState.update {
                    it.copy(
                        hasUsernameError = action.hasError,
                        usernameErrorMessage = action.errorMessage
                    )
                }
            }

            LoginUiAction.TogglePasswordVisibility -> {
                _uiState.update {
                    it.copy(
                        passwordVisibility = !it.passwordVisibility
                    )
                }
            }
        }
    }
}