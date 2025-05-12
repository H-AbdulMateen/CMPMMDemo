package com.abdulmateen.cmpmmdemo.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cmpmmdemo.core.ui.generated.resources.Res
import cmpmmdemo.core.ui.generated.resources.ic_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun LogoImage(
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(resource = Res.drawable.ic_logo),
        contentDescription = null,
        modifier = modifier
    )
}