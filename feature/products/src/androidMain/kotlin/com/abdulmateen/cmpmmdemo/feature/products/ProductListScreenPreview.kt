package com.abdulmateen.cmpmmdemo.feature.products

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.ProductListScreen
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.ProductListUiState

@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview(modifier: Modifier = Modifier) {
    ProductListScreen(
        uiState = ProductListUiState(),
        navController = rememberNavController()
    )
}