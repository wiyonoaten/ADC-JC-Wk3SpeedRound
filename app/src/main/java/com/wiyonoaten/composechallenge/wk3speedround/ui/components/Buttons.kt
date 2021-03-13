package com.wiyonoaten.composechallenge.wk3speedround.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.text_button_height
import java.util.Locale

@Composable
fun CustomTextButton(
    text: String,
    colors: ButtonColors,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    TextButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = colors,
        modifier = modifier
            .height(text_button_height)
            .fillMaxWidth()
    ) {
        Text(
            text = text.toUpperCase(Locale.getDefault())
        )
    }
}

@Composable
fun PrimaryTextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    CustomTextButton(
        text = text,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        ),
        onClick = onClick,
        modifier = modifier
    )
}

@Composable
fun SecondaryTextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    CustomTextButton(
        text = text,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary
        ),
        onClick = onClick,
        modifier = modifier
    )
}
