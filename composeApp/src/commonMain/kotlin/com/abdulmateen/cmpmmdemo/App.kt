package com.abdulmateen.cmpmmdemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdulmateen.cmpmmdemo.feature.auth.navigation.AuthNavGraph
import com.abdulmateen.cmpmmdemo.main.MainScreen
import com.abdulmateen.cmpmmdemo.navigation.AppNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            NavHost(
                startDestination = AppNavigation.Auth,
                navController = navController
            ){
                composable<AppNavigation.Auth> {
                    AuthNavGraph (onLoginSuccess = {
                        navController.popBackStack()
                        navController.navigate(AppNavigation.Main)})
                }
                composable<AppNavigation.Main> {
                    MainScreen(
                        onLogout = {
                            navController.popBackStack()
                            navController.navigate(AppNavigation.Auth)
                        }
                    )
                }
            }
        }
    }
}