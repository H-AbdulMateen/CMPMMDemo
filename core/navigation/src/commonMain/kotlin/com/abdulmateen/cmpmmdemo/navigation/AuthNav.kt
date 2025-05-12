package com.abdulmateen.cmpmmdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

@Composable
fun AuthNav(navigateToMain: () -> Unit){
    val navController = rememberNavController()
    NavHost(
        startDestination = AppNavigation.Auth,
        navController = navController,
    ){
        composable<AppNavigation.Auth>{

        }
    }
}