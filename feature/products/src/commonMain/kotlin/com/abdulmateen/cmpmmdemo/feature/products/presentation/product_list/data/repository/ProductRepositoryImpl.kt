package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.repository

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.core.domain.map
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.ktor.KtorProductsDataSource
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.ktor.RemoteProductsDataSource
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.mappers.toProduct
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain.Product
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain.ProductRepository

class ProductRepositoryImpl(
    private val remoteDataSource: RemoteProductsDataSource
): ProductRepository {
    override suspend fun fetchProducts(): Result<List<Product>, DataError.Remote> {
        return remoteDataSource
            .fetchProducts()
            .map {dtoList ->
                dtoList.map { it.toProduct() }
            }
    }
}