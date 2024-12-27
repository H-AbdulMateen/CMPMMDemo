package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import cmpmmdemo.feature.products.generated.resources.Res
import cmpmmdemo.feature.products.generated.resources.ic_logo
import cmpmmdemo.feature.products.generated.resources.ic_notification
import cmpmmdemo.feature.products.generated.resources.ic_search
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductListScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBarCentered()
        }
    ) {innerPadding ->

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
            Image(painter = painterResource(resource = Res.drawable.ic_logo), contentDescription = "LogoImage",
                modifier = Modifier.size(48.dp))
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
