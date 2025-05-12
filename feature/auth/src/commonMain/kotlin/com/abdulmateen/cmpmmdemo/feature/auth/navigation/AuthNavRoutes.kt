package com.abdulmateen.cmpmmdemo.feature.auth.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AuthNavRoutes {
    @Serializable
    data object Auth : AuthNavRoutes()
    @Serializable
    data object Login: AuthNavRoutes()
    @Serializable
    data object SignUp: AuthNavRoutes()
    @Serializable
    data object ForgotPassword: AuthNavRoutes()
}