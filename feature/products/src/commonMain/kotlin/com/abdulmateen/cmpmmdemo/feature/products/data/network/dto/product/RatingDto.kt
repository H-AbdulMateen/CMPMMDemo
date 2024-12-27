package com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatingDto(
    @SerialName("count")
    val count: Int?,
    @SerialName("rate")
    val rate: Double?
)