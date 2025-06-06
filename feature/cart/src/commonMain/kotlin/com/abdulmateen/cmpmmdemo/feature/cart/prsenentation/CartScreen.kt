package com.abdulmateen.cmpmmdemo.feature.cart.prsenentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CartScreenRoot(){
    CartScreen()
}

@Composable
fun CartScreen() {
    Scaffold {innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Cart Screen")
        }
    }
}