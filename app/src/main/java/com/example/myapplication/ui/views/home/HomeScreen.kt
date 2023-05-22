package com.example.myapplication.ui.views.home

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.navigation.Screen
import com.example.myapplication.ui.theme.Color_Transp
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.views.home.component.FeedCard
import com.example.myapplication.ui.views.home.component.NewsFeedHeader
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun HomeScreen(
    actions: MainActions
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 16.dp,
                start = 0.dp,
                end = 0.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NewsFeedHeader(
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        )
        Box(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 0.dp
            )
                .fillMaxHeight()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(10) {
                    FeedCard(actions = actions)
                }
            }
        }
    }
}