package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain


data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)