package com.example.myapplication.ui.views.save

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.views.home.component.FeedCard
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun SaveScreen(
    actions: MainActions
) {

    Box(
        modifier = Modifier.padding(
            start = 20.dp,
            end = 20.dp,
            top = 10.dp
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