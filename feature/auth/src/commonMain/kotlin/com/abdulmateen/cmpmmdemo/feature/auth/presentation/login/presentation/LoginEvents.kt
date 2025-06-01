package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.presentation

import com.abdulmateen.cmpmmdemo.core.common.presentation.UiText

sealed class LoginEvents {
    data object OnSuccess: LoginEvents()
}