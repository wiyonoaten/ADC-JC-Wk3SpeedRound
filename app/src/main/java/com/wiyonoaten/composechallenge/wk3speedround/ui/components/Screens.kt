package com.wiyonoaten.composechallenge.wk3speedround.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource

@Composable
fun BackgroundThemedScreen(
    drawableResPair: ThemeDrawableResIdPair,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit = {}
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = when(isDarkTheme) {
                    true -> drawableResPair.darkId
                    else -> drawableResPair.lightId
                }),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            content()
        }
    }
}

data class ThemeDrawableResIdPair(
    @DrawableRes val darkId: Int,
    @DrawableRes val lightId: Int
)
