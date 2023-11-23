package com.example.myapplication.ui.views.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.White_Color

@Composable
internal fun ScreenHeader(title: String, actions: MainActions) {
    TopAppBar(
        backgroundColor = White_Color,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = { actions.popBackStack.invoke() }) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_back
                    ),
                    contentDescription = "",
                    tint = Dark_Blue
                )
            }

            CustomText(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Dark_Blue
                ),
            )

            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}