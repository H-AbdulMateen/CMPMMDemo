package com.abdulmateen.cmpmmdemo.feature.wishlist.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WishlistScreenRoot(){
    WishlistScreen()
}

@Composable
fun WishlistScreen() {
    Scaffold {innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Wishlist Screen")
        }
    }
}