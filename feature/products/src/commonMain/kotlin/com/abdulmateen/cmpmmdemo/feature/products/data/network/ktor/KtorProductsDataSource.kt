package com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.core.network.ktor.safeCall
import com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product.ProductDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get

private const val BASE_URL = "https://fakestoreapi.com/"

class KtorProductsDataSource(
    private val httpClient: HttpClient
): RemoteProductsDataSource {
    override suspend fun fetchProducts(): Result<List<ProductDto>, DataError.Remote> {

        return safeCall<List<ProductDto>> {
            httpClient.get(
                urlString = BASE_URL + "products"
            )
        }
    }
}