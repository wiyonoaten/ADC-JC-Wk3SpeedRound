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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiyonoaten.composechallenge.wk3speedround.data.ALIGN_YOUR_BODY_CATEGORIES
import com.wiyonoaten.composechallenge.wk3speedround.data.ALIGN_YOUR_MIND_CATEGORIES
import com.wiyonoaten.composechallenge.wk3speedround.data.CourseCategory
import com.wiyonoaten.composechallenge.wk3speedround.data.FAVORITE_COLLECTIONS
import com.wiyonoaten.composechallenge.wk3speedround.data.SootheCollection
import com.wiyonoaten.composechallenge.wk3speedround.ui.components.CustomTextField
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.MyTheme
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.account_circle
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.play_arrow
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.screen_content_padding_horiz
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.search
import com.wiyonoaten.composechallenge.wk3speedround.ui.theme.spa
import java.util.Locale

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
private fun HomeScreen(isDarkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = play_arrow,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            ) {
                AppBarIconButton(
                    icon = spa,
                    text = "Home"
                )
                AppBarIconButton(
                    icon = account_circle,
                    text = "Profile"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.size(56.dp))
            Box(
                modifier = Modifier.padding(screen_content_padding_horiz)
            ) {
                val searchKeywordsState = remember { mutableStateOf(TextFieldValue()) }

                CustomTextField(
                    value = searchKeywordsState.value,
                    onValueChange = { searchKeywordsState.value = it },
                    placeholderText = "Search",
                    leadingIcon = {
                        Icon(search, contentDescription = null, modifier = Modifier.size(18.dp))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column(
                modifier = Modifier.padding(start = screen_content_padding_horiz)
            ) {
                Text(
                    text = "Favorite Collections".toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.paddingFromBaseline(40.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                FavoriteCollections(FAVORITE_COLLECTIONS)
                Spacer(modifier = Modifier.size(32.dp))
                Text(
                    text = "Align Your Body".toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.size(8.dp))
                CourseCategories(
                    itemList = ALIGN_YOUR_BODY_CATEGORIES
                )
                Spacer(modifier = Modifier.size(32.dp))
                Text(
                    text = "Align Your Mind".toUpperCase(Locale.getDefault()),
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.size(8.dp))
                CourseCategories(
                    itemList = ALIGN_YOUR_MIND_CATEGORIES
                )
                Spacer(modifier = Modifier.size(100.dp))
            }
        }
    }
}

@Composable
private fun RowScope.AppBarIconButton(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(
        onClick = onClick,
        modifier = modifier.weight(1.0f, true)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp))
            Text(
                text = text.toUpperCase(Locale.getDefault()),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
private fun FavoriteCollections(
    collections: List<SootheCollection>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier) {
        val itemList = collections.windowed(2, 2).map { Pair(it[0], it[1]) }
        itemList.forEach {
            item {
                Column(
                    modifier = Modifier
                        .padding(end = 8.dp)
                ) {
                    it.toList().forEach {
                        Card(
                            shape = MaterialTheme.shapes.small,
                            elevation = 0.dp,
                            modifier = Modifier
                                .size(192.dp, 56.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = it.photoResId),
                                    contentDescription = it.name,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(56.dp)
                                )
                                Text(
                                    text = it.name,
                                    style = MaterialTheme.typography.h3,
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun CourseCategories(
    itemList: List<CourseCategory>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier) {
        itemList.forEach {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(end = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = it.photoResId),
                        contentDescription = it.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(88.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier
                            .paddingFromBaseline(24.dp)
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(isDarkTheme = true) {
        HomeScreen(isDarkTheme = true)
    }
}
