package com.abdulmateen.cmpmmdemo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.ProductListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        ProductListScreen()
    }
}