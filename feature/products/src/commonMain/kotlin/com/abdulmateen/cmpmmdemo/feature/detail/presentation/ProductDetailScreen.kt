package com.abdulmateen.cmpmmdemo.feature.detail.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProductDetailScreenRoot(
    navController: NavController
) {
    ProductDetailScreen()
}

@Composable
fun ProductDetailScreen() {
    Scaffold {
        Text(text = "Detail")
    }
}