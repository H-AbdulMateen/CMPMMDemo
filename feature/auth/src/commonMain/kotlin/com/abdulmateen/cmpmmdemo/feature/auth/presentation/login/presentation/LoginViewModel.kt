package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdulmateen.cmpmmdemo.core.common.presentation.toUiText
import com.abdulmateen.cmpmmdemo.core.domain.onError
import com.abdulmateen.cmpmmdemo.core.domain.onSuccess
import com.abdulmateen.cmpmmdemo.core.ui.utils.Validator
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.domain.LoginRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()


    fun uiAction(action: LoginUiAction) {
        when(action){
            LoginUiAction.OnLoginClicked -> { validateField() }
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
            LoginUiAction.ToggleAlertDialog -> {
                _uiState.update {
                    it.copy(
                        isAlertDialogOpened = !it.isAlertDialogOpened
                    )
                }
            }
        }
    }

    private fun validateField() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            val isUsernameValid = Validator.validateNonEmpty(_uiState.value.username)
            if (!isUsernameValid.isValid)
                return@launch

            val isPasswordValid = Validator.validateNonEmpty(_uiState.value.password)
            if (!isPasswordValid.isValid)
                return@launch

            login()
        }
    }

    private suspend fun login(){
        repository.login(
            username = uiState.value.username,
            password = uiState.value.password
        )
            .onSuccess {result ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        navigateToMain = true
                    )
                }
            }
            .onError {error ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.toUiText(),
                        isAlertDialogOpened = true
                    )
                }
            }
    }
}