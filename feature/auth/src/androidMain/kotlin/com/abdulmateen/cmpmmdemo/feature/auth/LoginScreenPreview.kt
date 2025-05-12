package com.abdulmateen.cmpmmdemo.feature.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.LoginScreen
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.LoginUiState


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginUiState(),
        uiAction = {},
        onLoginSuccess = {},
        navController = rememberNavController()
    )
}