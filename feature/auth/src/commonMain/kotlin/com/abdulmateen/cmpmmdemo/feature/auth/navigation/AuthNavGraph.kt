package com.abdulmateen.cmpmmdemo.feature.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.presentation.LoginScreenRoot

@Composable
fun AuthNavGraph(
    onLoginSuccess: () -> Unit
){
    val navController = rememberNavController()

    NavHost(
        startDestination = AuthNavRoutes.Login,
        navController = navController
    ){
        composable<AuthNavRoutes.Login> {
            LoginScreenRoot(
                onLoginSuccess = onLoginSuccess
            )
        }
    }
}