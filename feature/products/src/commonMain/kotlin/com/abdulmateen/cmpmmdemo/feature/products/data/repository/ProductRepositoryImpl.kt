package com.abdulmateen.cmpmmdemo.feature.products.data.repository

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.core.domain.map
import com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor.KtorProductsDataSource
import com.abdulmateen.cmpmmdemo.feature.products.data.network.mappers.toProduct
import com.abdulmateen.cmpmmdemo.feature.products.domain.Product
import com.abdulmateen.cmpmmdemo.feature.products.domain.ProductRepository

class ProductRepositoryImpl(
    private val remoteDataSource: KtorProductsDataSource
): ProductRepository {
    override suspend fun fetchProducts(): Result<List<Product>, DataError.Remote> {
        return remoteDataSource
            .fetchProducts()
            .map {dtoList ->
                dtoList.map { it.toProduct() }
            }
    }
}