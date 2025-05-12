package com.abdulmateen.cmpmmdemo.main

import kotlinx.serialization.Serializable

@Serializable
sealed class BottomNavRoutes {
    @Serializable
    data object Home : BottomNavRoutes()
    @Serializable
    data object Wishlist : BottomNavRoutes()
    @Serializable
    data object Cart : BottomNavRoutes()
    @Serializable
    data object Profile : BottomNavRoutes()
}