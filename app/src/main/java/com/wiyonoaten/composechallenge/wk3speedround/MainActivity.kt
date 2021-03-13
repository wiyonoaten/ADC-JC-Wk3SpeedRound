/*
 * Copyright 2021 Wiyono Aten
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wiyonoaten.composechallenge.wk3speedround

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.BackgroundThemedScreen
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.PrimaryTextButton
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.SecondaryTextButton
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.ThemeDrawableResIdPair
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.MyTheme
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.screen_content_padding_horiz

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                WelcomeScreen()
            }
        }
    }
}

@Composable
private fun WelcomeScreen(isDarkTheme: Boolean = isSystemInDarkTheme()) {
    BackgroundThemedScreen(
        drawableResPair = ThemeDrawableResIdPair(
            darkId = R.drawable.ic_dark_welcome,
            lightId = R.drawable.ic_light_welcome
        ),
        isDarkTheme = isDarkTheme
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(screen_content_padding_horiz)
        ) {
            val context = LocalContext.current

            Image(
                imageVector = ImageVector.vectorResource(id = when(isDarkTheme) {
                    true -> R.drawable.ic_dark_logo
                    else -> R.drawable.ic_light_logo
                }),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.size(32.dp))
            PrimaryTextButton("Sign Up")
            Spacer(modifier = Modifier.size(8.dp))
            SecondaryTextButton(
                text = "Log In",
                onClick = {
                    context.startActivity(Intent(context, LoginActivity::class.java))
                }
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        WelcomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(isDarkTheme = true) {
        WelcomeScreen(isDarkTheme = true)
    }
}
