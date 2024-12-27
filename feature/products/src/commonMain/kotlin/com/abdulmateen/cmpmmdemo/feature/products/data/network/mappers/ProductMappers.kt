package com.abdulmateen.cmpmmdemo.feature.products.data.network.mappers

import com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product.ProductDto
import com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product.RatingDto
import com.abdulmateen.cmpmmdemo.feature.products.domain.Product
import com.abdulmateen.cmpmmdemo.feature.products.domain.Rating

fun ProductDto.toProduct(): Product {
    return Product(
        category = category ?: "",
        description = description ?: "",
        id = id ?: 0,
        image = image ?: "",
        price = price ?: 0.0,
        rating = rating?.toRating() ?: Rating(count = 0, rate = 0.0),
        title =  title ?: ""

    )
}

fun RatingDto.toRating(): Rating {
    return Rating(
        count = count ?: 0,
        rate = rate ?: 0.0

    )
}