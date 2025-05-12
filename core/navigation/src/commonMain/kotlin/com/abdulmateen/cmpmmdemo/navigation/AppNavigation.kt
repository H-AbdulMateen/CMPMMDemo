package com.abdulmateen.cmpmmdemo.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppNavigation {
    @Serializable
    data object Auth: AppNavigation()
    @Serializable
    data object Main: AppNavigation()
}