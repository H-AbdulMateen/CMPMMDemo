package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abdulmateen.cmpmmdemo.feature.products.domain.Product

@Composable
fun ProductListItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    item: Product
) {
    OutlinedCard(
        onClick = onClick
    ){
        Box(
            modifier = Modifier.height(100.dp)
        ) {

        }
    }
}