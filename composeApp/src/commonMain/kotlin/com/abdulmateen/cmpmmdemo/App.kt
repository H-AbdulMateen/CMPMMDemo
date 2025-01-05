package com.abdulmateen.cmpmmdemo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.ProductListScreen
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.ProductListScreenRoot
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.ProductListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        ProductListScreenRoot()
    }
}