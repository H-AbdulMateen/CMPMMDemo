package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result


interface ProductRepository {
    suspend fun fetchProducts(): Result<List<Product>, DataError.Remote>

}