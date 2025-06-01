package com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cmpmmdemo.feature.products.generated.resources.Res
import cmpmmdemo.feature.products.generated.resources.book_error
import cmpmmdemo.feature.products.generated.resources.ic_border_color
import cmpmmdemo.feature.products.generated.resources.ic_heart
import cmpmmdemo.feature.products.generated.resources.ic_location
import cmpmmdemo.feature.products.generated.resources.ic_notes
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain.Product
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductListItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    item: Product
) {
    OutlinedCard(
        onClick = onClick,
        colors = CardDefaults.outlinedCardColors(
            containerColor = White
        )
    ) {
        Box(
            modifier = Modifier.height(150.dp)
        ) {

            var imageLoadResult by remember {
                mutableStateOf<Result<Painter>?>(null)
            }
            val painter = rememberAsyncImagePainter(
                model = item.image,
                onSuccess = {
                    imageLoadResult =
                        if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                            Result.success(it.painter)
                        } else {
                            Result.failure(Exception("Invalid image size"))
                        }
                },
                onError = {
                    it.result.throwable.printStackTrace()
                    imageLoadResult = Result.failure(it.result.throwable)
                }
            )

            val painterState by painter.state.collectAsStateWithLifecycle()
            val transition by animateFloatAsState(
                targetValue = if (painterState is AsyncImagePainter.State.Success) {
                    1f
                } else {
                    0f
                },
                animationSpec = tween(durationMillis = 800)
            )

            when (val result = imageLoadResult) {
                null -> CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
                else -> {
                    Image(
                        painter = if (result.isSuccess) painter else {
                            painterResource(Res.drawable.book_error)
                        },
                        contentDescription = item.title,
                        contentScale = if (result.isSuccess) {
                            ContentScale.Fit
                        } else {
                            ContentScale.Fit
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .align(alignment = Alignment.Center)
                            .aspectRatio(
                                ratio = 0.65f,
                                matchHeightConstraintsFirst = true,
                            )
                            .graphicsLayer {
                                rotationX = (1f - transition) * 30f
                                val scale = 0.8f + (0.2f * transition)
                                scaleX = scale
                                scaleY = scale
                            }
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                FilledIconButton(
                    onClick = {},
                    content = {
                        Icon(
                            painter = painterResource(Res.drawable.ic_notes),
                            contentDescription = "DocumentIcon",
                            modifier = Modifier.padding(2.dp)
                        )
                    },
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Green.copy(alpha = 0.1f),
                        contentColor = DarkGray
                    ),
                    modifier = Modifier.size(18.dp)
                )
                FilledIconButton(
                    onClick = {},
                    content = {
                        Icon(
                            painter = painterResource(Res.drawable.ic_heart),
                            contentDescription = "HeartIcon",
                            modifier = Modifier.padding(2.dp)
                        )
                    },
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = LightGray.copy(alpha = 0.3f),
                        contentColor = Black
                    ),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
        Column(
            modifier = Modifier.padding(8.dp)
        ) {

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(Res.drawable.ic_border_color), contentDescription = "BorderColor", modifier = Modifier.size(16.dp), tint = Green.copy(alpha = 0.3f))
                Text(text = "Author Name", style = MaterialTheme.typography.bodySmall.copy(fontSize = 9.sp, color = Gray))
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(Res.drawable.ic_location), contentDescription = "Location", modifier = Modifier.size(16.dp), tint = Green.copy(alpha = 0.3f))
                Text(text = "Abc Address", style = MaterialTheme.typography.bodySmall.copy(fontSize = 9.sp, color = Gray))
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Rs ${item.price}", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Green))
                Text(text = "2 hours ago", style = MaterialTheme.typography.bodySmall.copy(fontSize = 9.sp, color = Gray))
            }
        }
    }
}