package com.wiyonoaten.composechallenge.wk3speedround.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.text_field_height

@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = false,
    placeholderText: String = "",
    leadingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
            Text(
                text = placeholderText,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.body1
            )
        },
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            backgroundColor = when(isDarkTheme) {
                true -> MaterialTheme.colors.onSurface.copy(alpha = TextFieldDefaults.BackgroundOpacity)
                else -> MaterialTheme.colors.surface
            },
            unfocusedIndicatorColor = MaterialTheme.colors.primary
        ),
        leadingIcon = leadingIcon,
        modifier = modifier
            .height(text_field_height)
    )
}
