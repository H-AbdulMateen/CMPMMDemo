package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login

data class LoginUiState(
    val isLoading: Boolean = false,
    val username: String = "",
    val hasUsernameError: Boolean = false,
    val usernameErrorMessage: String = "",
    val password: String = "",
    val hasPasswordError: Boolean = false,
    val passwordErrorMessage: String = "",
    val passwordVisibility: Boolean = false
)
