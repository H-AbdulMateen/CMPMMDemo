package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdulmateen.cmpmmdemo.core.domain.onError
import com.abdulmateen.cmpmmdemo.core.domain.onSuccess
import com.abdulmateen.cmpmmdemo.feature.products.domain.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val repository: ProductRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ProductListUiState())
    val uiState = _uiState
        .onStart {
            loadProducts()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            ProductListUiState()
        )



    private fun loadProducts() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            repository
                .fetchProducts()
                .onSuccess { searchResults ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            productList = searchResults
//                            errorMessage = null,
                        )
                    }
                }
                .onError { error ->
                    _uiState.update {
                        it.copy(
                            productList = emptyList(),
                            isLoading = false,
//                            errorMessage = error.toUiText()
                        )
                    }
                }
        }
    }
}