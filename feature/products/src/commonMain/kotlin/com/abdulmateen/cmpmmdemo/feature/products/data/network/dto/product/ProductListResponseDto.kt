package com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product

import kotlinx.serialization.Serializable


@Serializable
data class ProductListResponseDto(
    val products: List<ProductDto?>
)