package com.abdulmateen.cmpmmdemo.feature.products.data.repository

import com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product.ProductDto
import com.abdulmateen.cmpmmdemo.feature.products.data.network.dto.product.RatingDto
import com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor.KtorProductsDataSource

class TestProductRepositoryImpl {


    private fun getProductResponse(): List<ProductDto>{
        return listOf(
            ProductDto(
                category = "Category 1",
                description = "Description 1",
                id = 1,
                image = "image1",
                price = 10.0,
                rating = RatingDto(count = 1, rate = 5.0),
                title = "Title 1"

            ),
            ProductDto(
                category = "Category 2",
                description = "Description 2",
                id = 2,
                image = "image2",
                price = 10.0,
                rating = RatingDto(count = 1, rate = 5.0),
                title = "Title 2"

            ),
            ProductDto(
                category = "Category 3",
                description = "Description 3",
                id = 3,
                image = "image3",
                price = 30.0,
                rating = RatingDto(count = 1, rate = 5.0),
                title = "Title 3"

            ),
            ProductDto(
                category = "Category 4",
                description = "Description 4",
                id = 4,
                image = "image4",
                price = 0.0,
                rating = RatingDto(count = 1, rate = 5.0),
                title = "Title 4"

            ),
        )
    }
}