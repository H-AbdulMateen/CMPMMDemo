package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.presentation

import androidx.compose.runtime.Immutable
import com.abdulmateen.cmpmmdemo.core.common.presentation.UiText
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain.Product

@Immutable
data class ProductListUiState(
    val isLoading: Boolean = false,
    val productList: List<Product> = emptyList(),
    val errorMessage: UiText? = null
)