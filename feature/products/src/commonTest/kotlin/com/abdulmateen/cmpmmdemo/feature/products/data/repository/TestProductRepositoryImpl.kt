package com.abdulmateen.cmpmmdemo.feature.products.data.repository

import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product.ProductDto
import com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product.RatingDto
import com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor.FakeKtorProductDataSource
import com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor.FakeProductDataGenerator
import com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor.FakeProductDataSourceResponseType
import com.abdulmateen.cmpmmdemo.feature.products.data.network.mappers.toProduct
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestProductRepositoryImpl {
    @Test
    fun `fetchProducts returns list of Products on success`() = runBlocking {
        val dataSource = FakeKtorProductDataSource.build(FakeProductDataSourceResponseType.SuccessData)
        val result = dataSource.fetchProducts()
        assertTrue(actual = result is Result.Success)
        assertEquals(expected = FakeProductDataGenerator.productList.map { it.toProduct() }, actual = result.data.map { it.toProduct() })
    }
}