package com.abdulmateen.cmpmmdemo.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abdulmateen.cmpmmdemo.feature.cart.prsenentation.CartScreenRoot
import com.abdulmateen.cmpmmdemo.feature.products.navigation.HomeNavGraph
import com.abdulmateen.cmpmmdemo.feature.profile.presentation.ProfileScreenRoot
import com.abdulmateen.cmpmmdemo.feature.wishlist.presentation.WishlistScreenRoot
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(
    onLogout: () -> Unit
) {
    val navBottomController = rememberNavController()
    Column(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background)) {
        Box(modifier = Modifier.weight(.1f)) {
            NavHost(
                navController = navBottomController,
                startDestination = BottomNavRoutes.Home
            ) {
                composable<BottomNavRoutes.Home> {
                    HomeNavGraph()
                }
                composable<BottomNavRoutes.Wishlist> {
                    WishlistScreenRoot()
                }
                composable<BottomNavRoutes.Cart> {
                    CartScreenRoot()
                }
                composable<BottomNavRoutes.Profile> {
                    ProfileScreenRoot(
                        onLogout = onLogout
                    )
                }
            }
        }
        BottomNavigationUI(navController = navBottomController)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomNavigationUI(
    navController: NavController,
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        )
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.background,
            tonalElevation = 8.dp
        ) {

            val items = listOf(
                BottomNavigation.Home,
                BottomNavigation.Wishlist,
                BottomNavigation.Cart,
                BottomNavigation.Profile,
            )
            items.forEach {
                NavigationBarItem(
                    label = { Text(text = it.title) },
                    selected = it.route == currentRoute,
                    icon = {
                        Icon(
                            painterResource(if (it.route == currentRoute) it.selectedIcon else it.unSelectedIcon),
                            it.title
                        )
                    },
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.navigate(it.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    })
            }
        }
    }
}