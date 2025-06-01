package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.presentation

import com.abdulmateen.cmpmmdemo.core.common.presentation.UiText

data class LoginUiState(
    val isLoading: Boolean = false,
    val username: String = "johnd",
    val hasUsernameError: Boolean = false,
    val usernameErrorMessage: String = "",
    val password: String = "m38rmF$",
    val hasPasswordError: Boolean = false,
    val passwordErrorMessage: String = "",
    val passwordVisibility: Boolean = false,
    val errorMessage: UiText = UiText.DynamicString(""),
    val isAlertDialogOpened: Boolean = false,
    val navigateToMain: Boolean = false
)
