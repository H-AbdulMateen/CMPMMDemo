package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.ktor

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.dto.product.ProductDto

interface RemoteProductsDataSource {
    suspend fun fetchProducts(): Result<List<ProductDto>, DataError.Remote>
}