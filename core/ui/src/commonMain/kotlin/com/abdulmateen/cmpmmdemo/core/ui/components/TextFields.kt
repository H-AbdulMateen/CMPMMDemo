package com.abdulmateen.cmpmmdemo.core.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cmpmmdemo.core.ui.generated.resources.Res
import cmpmmdemo.core.ui.generated.resources.ic_visibility
import cmpmmdemo.core.ui.generated.resources.ic_visibility_off
import org.jetbrains.compose.resources.painterResource


@Composable
fun OutlinedTF(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    hasError: Boolean = false,
    errorMessage: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = { Text(text = placeholder) },
        isError = hasError,
        supportingText = {
            if (hasError) {
                Text(text = errorMessage)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = singleLine
    )
}

@Composable
fun OutlinedTFPassword(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    hasError: Boolean = false,
    errorMessage: String = "",
    keyboardType: KeyboardType = KeyboardType.Password,
    visibility: Boolean = false,
    toggleVisibility: () -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = { Text(text = placeholder) },
        isError = hasError,
        supportingText = {
            if (hasError) {
                Text(text = errorMessage)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        trailingIcon = {
            Icon(
                painter = painterResource(if (visibility) Res.drawable.ic_visibility_off else Res.drawable.ic_visibility),
                contentDescription = "VisibilityIcon",
                modifier = Modifier.clickable(
                    onClick = toggleVisibility
                ).size(24.dp)
            )
        }
    )
}