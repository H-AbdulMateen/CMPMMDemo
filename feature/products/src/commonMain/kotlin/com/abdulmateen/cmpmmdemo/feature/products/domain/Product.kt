package com.abdulmateen.cmpmmdemo.feature.products.domain


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)