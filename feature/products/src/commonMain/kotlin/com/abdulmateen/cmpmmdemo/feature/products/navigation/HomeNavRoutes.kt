package com.abdulmateen.cmpmmdemo.feature.products.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class HomeNavRoutes {
    @Serializable
    data object Products : HomeNavRoutes()
    @Serializable
    data object Detail: HomeNavRoutes()
}