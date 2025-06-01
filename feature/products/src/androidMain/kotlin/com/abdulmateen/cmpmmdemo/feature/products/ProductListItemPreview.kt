package com.abdulmateen.cmpmmdemo.feature.products

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain.Product
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain.Rating
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.presentation.components.ProductListItem

@Preview
@Composable
private fun ProductListItemPreview() {
    ProductListItem(
        onClick = {},
        item = Product(
            category = "men's clothing",
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            id = 1,
            image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            price = 109.95,
            rating = Rating(rate = 3.9, count = 120),
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
        )

    )
}