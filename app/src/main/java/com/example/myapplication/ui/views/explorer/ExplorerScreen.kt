package com.example.myapplication.ui.views.explorer

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.navigation.Screen
import com.example.myapplication.ui.common.feedCard.FeedCardDetail
import com.example.myapplication.ui.common.filterBox.FilterBox
import com.example.myapplication.ui.common.searchField.SearchField
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.views.explorer.component.ExplorerCard
import com.example.myapplication.ui.views.home.component.FeedCard
import com.example.myapplication.ui.views.home.component.NewsFeedHeader
import com.ramcosta.composedestinations.annotation.Destination
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Gold_Color

@Destination
@Composable
fun ExplorerScreen(
    actions: MainActions
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp,
                start = 20.dp,
                end = 20.dp
            ),
        horizontalAlignment = Alignment.Start
    ) {
        Column {
            CustomText(
                text = "Be Together",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Dark_Blue
                )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomText(
                    text = "Better Society",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Dark_Blue
                    )
                )
                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            shape =
                                RoundedCornerShape(
                                    50.dp
                                )
                            clip = true
                        }
                        .background(
                            Color.Black.copy(
                                0.1f
                            )
                        )
                        .padding(
                            horizontal = 7.dp,
                            vertical = 2.dp
                        )
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            5.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(
                                12.dp
                            ),
                            painter = painterResource(
                                id = R.drawable.saving
                            ),
                            contentDescription = "",
                            tint = Gold_Color,
                        )
                        CustomText(
                            text = "Fundraising",
                            style = TextStyle(
                                fontSize = 10.sp
                            )
                        )
                    }
                }

            }
        }

        // Filter
        FilterBox(
            Modifier.padding(
                top = 15.dp,
                bottom = 5.dp
            )
        )

        Box(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxHeight()

        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(
                    20.dp
                )
            ) {
                items(10) {
                    Column{
                        ExplorerCard(actions = actions)
                        Spacer(modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Black.copy(0.1f)))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExporerPreview() {
    val navController =
        rememberNavController()
    ExplorerScreen(
        actions = MainActions(
            navController
        )
    )
}