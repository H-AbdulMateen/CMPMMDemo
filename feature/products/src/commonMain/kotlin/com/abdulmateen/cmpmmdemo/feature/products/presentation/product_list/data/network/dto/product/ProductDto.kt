package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.dto.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @SerialName("category")
    val category: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("price")
    val price: Double? = null,
    @SerialName("rating")
    val rating: RatingDto? = null,
    @SerialName("title")
    val title: String? = null
)