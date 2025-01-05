package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cmpmmdemo.feature.products.generated.resources.Res
import cmpmmdemo.feature.products.generated.resources.ic_logo
import cmpmmdemo.feature.products.generated.resources.ic_notification
import cmpmmdemo.feature.products.generated.resources.ic_search
import com.abdulmateen.cmpmmdemo.feature.products.domain.Product
import com.abdulmateen.cmpmmdemo.feature.products.domain.Rating
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.components.ProductListItem
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductListScreenRoot(
    viewModel: ProductListViewModel = koinViewModel()
) {
    ProductListScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    )
}

@Composable
fun ProductListScreen(
    uiState: ProductListUiState
) {
    Scaffold(
        topBar = {
            TopBarCentered()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (uiState.isLoading){
                CircularProgressIndicator()
            }
            else if (uiState.errorMessage != null){
                Text(
                    text = uiState.errorMessage.asString(),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            else{
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize().padding(innerPadding).padding(8.dp),
                    columns = GridCells.Fixed(count = 2),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(items = uiState.productList) { item ->
                        ProductListItem(
                            onClick = {},
                            item = item
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBarCentered() {
    CenterAlignedTopAppBar(
        navigationIcon = {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .drawBehind {
                        drawCircle(
                            color = Blue,
                            radius = this.size.maxDimension
                        )
                    },
                text = "S",
                color = White
            )
        },
        title = {
            Image(
                painter = painterResource(resource = Res.drawable.ic_logo),
                contentDescription = "LogoImage",
                modifier = Modifier.size(48.dp)
            )
        },
        actions = {
            Row {
                Icon(
                    painter = painterResource(Res.drawable.ic_notification),
                    contentDescription = "Notification",
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(Res.drawable.ic_search),
                    contentDescription = "Search",
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    )
}
