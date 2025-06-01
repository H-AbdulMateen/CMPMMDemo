package com.abdulmateen.cmpmmdemo.feature.products.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdulmateen.cmpmmdemo.feature.products.presentation.detail.presentation.ProductDetailScreenRoot
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.presentation.ProductListScreenRoot

@Composable
fun HomeNavGraph(){
    val navController = rememberNavController()
    NavHost(
        startDestination = HomeNavRoutes.Products,
        navController = navController
    ) {

        composable<HomeNavRoutes.Products> {
            ProductListScreenRoot(navController = navController)
        }

        composable<HomeNavRoutes.Detail> {
            ProductDetailScreenRoot(navController = navController)
        }
    }
}