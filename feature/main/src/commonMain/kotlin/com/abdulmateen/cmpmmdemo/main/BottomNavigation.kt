package com.abdulmateen.cmpmmdemo.main

import cmpmmdemo.feature.main.generated.resources.Res
import cmpmmdemo.feature.main.generated.resources.cart
import cmpmmdemo.feature.main.generated.resources.cart_border
import cmpmmdemo.feature.main.generated.resources.heart2
import cmpmmdemo.feature.main.generated.resources.heart_border2
import cmpmmdemo.feature.main.generated.resources.home
import cmpmmdemo.feature.main.generated.resources.home_border
import cmpmmdemo.feature.main.generated.resources.profile
import cmpmmdemo.feature.main.generated.resources.profile_border
import org.jetbrains.compose.resources.DrawableResource

sealed class BottomNavigation(
    val route: BottomNavRoutes,
    val title: String,
    val selectedIcon: DrawableResource,
    val unSelectedIcon: DrawableResource,
) {

    data object Home : BottomNavigation(
        route = BottomNavRoutes.Home,
        title = "Home",
        selectedIcon = Res.drawable.home,
        unSelectedIcon = Res.drawable.home_border
    )

    data object Wishlist : BottomNavigation(
        route = BottomNavRoutes.Wishlist,
        title = "Wishlist",
        selectedIcon = Res.drawable.heart2,
        unSelectedIcon = Res.drawable.heart_border2
    )

    data object Cart : BottomNavigation(
        route = BottomNavRoutes.Cart,
        title = "Cart",
        selectedIcon = Res.drawable.cart,
        unSelectedIcon = Res.drawable.cart_border
    )

    data object Profile : BottomNavigation(
        route = BottomNavRoutes.Profile,
        title = "Profile",
        selectedIcon = Res.drawable.profile,
        unSelectedIcon = Res.drawable.profile_border
    )


}