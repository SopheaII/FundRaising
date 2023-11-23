package com.example.myapplication.ui.views.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.views.notification.component.notificationCard
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun NotificationScreen(
    actions: MainActions
) {

    Box(
        modifier = Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 10.dp
            )
            .fillMaxHeight()
    ) {
        Column {
            CustomText(
                text = "Notification",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Dark_Blue
                ),
                modifier = Modifier.padding(bottom = 10.dp)
            )

            LazyColumn(
            ) {
                items(10) {
                    Column(modifier = Modifier.clickable {  }) {
                        notificationCard(
                            Modifier.padding(top = 10.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(
                                    Color.Black.copy(
                                        0.1f
                                    )
                                )
                        )
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    val navController =
        rememberNavController()
    NotificationScreen(
        actions = MainActions(
            navController
        )
    )
}