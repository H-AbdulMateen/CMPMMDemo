package com.abdulmateen.cmpmmdemo.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cmpmmdemo.core.ui.generated.resources.Res
import cmpmmdemo.core.ui.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun LogoImage(
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(resource = Res.drawable.compose_multiplatform),
        contentDescription = null,
        modifier = modifier
    )
}