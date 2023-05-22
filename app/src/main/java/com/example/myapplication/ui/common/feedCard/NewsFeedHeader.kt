package com.example.myapplication.ui.views.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.common.CustomText
import com.example.myapplication.ui.common.filterBox.FilterBox
import com.example.myapplication.ui.common.searchField.SearchField
import com.example.myapplication.ui.theme.Blue_Icon
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.theme.Green_Text
import com.example.myapplication.ui.theme.White_Color

@Composable
fun NewsFeedHeader(
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
            ) {
                Column() {
                    CustomText(
                        text = "Discover",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Dark_Blue
                        )
                    )
                    CustomText(
                        text = "New Feed",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Gray_Text
                        )
                    )
                }
                Spacer(
                    modifier = Modifier.width(
                        20.dp
                    )
                )
                SearchField()
            }

            // Filter
            FilterBox(Modifier.padding(top = 10.dp, bottom = 10.dp))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun NewsFeedHeaderPreview() {
    NewsFeedHeader(Modifier.padding(horizontal = 12.dp))
}