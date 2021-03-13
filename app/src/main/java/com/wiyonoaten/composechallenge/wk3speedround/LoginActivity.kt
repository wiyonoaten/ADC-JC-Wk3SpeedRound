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
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.BackgroundThemedScreen
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.CustomTextField
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.PrimaryTextButton
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.ThemeDrawableResIdPair
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.MyTheme
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.screen_content_padding_horiz
import java.util.Locale

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
private fun LoginScreen(isDarkTheme: Boolean = isSystemInDarkTheme()) {
    BackgroundThemedScreen(
        drawableResPair = ThemeDrawableResIdPair(
            darkId = R.drawable.ic_dark_login,
            lightId = R.drawable.ic_light_login
        ),
        isDarkTheme = isDarkTheme
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(screen_content_padding_horiz)
        ) {
            val context = LocalContext.current
            val emailAddressState = remember { mutableStateOf(TextFieldValue()) }
            val passwordState = remember { mutableStateOf(TextFieldValue()) }

            val textFieldLeadingSpacer = @Composable {
                Spacer(modifier = Modifier.size(1.dp))
            }

            Text(
                text = "Log In".toUpperCase(Locale.getDefault()),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.size(32.dp))
            CustomTextField(
                value = emailAddressState.value,
                onValueChange = { emailAddressState.value = it },
                placeholderText = "Email address",
                leadingIcon = textFieldLeadingSpacer,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(8.dp))
            CustomTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                placeholderText = "Password",
                leadingIcon = textFieldLeadingSpacer,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(8.dp))
            PrimaryTextButton(
                text = "Log In",
                onClick = {
                    context.startActivity(Intent(context, HomeActivity::class.java))
                }
            )
            Text(
                text = AnnotatedString.Builder().apply {
                    append("Don't have an account? ")
                    pushStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    append("Sign up")
                    pop()
                }.toAnnotatedString(),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.paddingFromBaseline(32.dp)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        LoginScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(isDarkTheme = true) {
        LoginScreen(isDarkTheme = true)
    }
}
