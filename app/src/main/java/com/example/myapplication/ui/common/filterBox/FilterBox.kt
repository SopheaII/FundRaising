package com.example.myapplication.ui.common.filterBox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.common.feedCard.FeedCardDetail
import com.example.myapplication.ui.theme.Blue_Icon
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.theme.Green_Text
import com.example.myapplication.ui.theme.White_Color
import com.example.myapplication.R

@Composable
internal fun FilterBox(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            0.dp
        ), modifier = modifier
            .horizontalScroll(
                rememberScrollState()
            )
    ) {
        for (it in 1..15) {
            Box(modifier = Modifier
                .graphicsLayer {
                    shape =
                        RoundedCornerShape(
                            50.dp
                        )
                    clip = true
                }
                .height(35.dp)
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            5.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        CustomText(
                            text = if (it == 1) "All" else "Tree Fundraising",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (it != 1) Gray_Text else Dark_Blue
                            ),
                        )

                        if (it != 1) {
                            Box(modifier = Modifier
                                .size(
                                    20.dp
                                )
                                .graphicsLayer {
                                    shape =
                                        RoundedCornerShape(
                                            50
                                        )
                                    clip = true
                                }
                                .background(
                                    Color.Gray.copy(
                                        alpha = 0.2f
                                    )
                                )) {
                                CustomText(
                                    text = "0",
                                    modifier = Modifier.align(
                                        Alignment.Center
                                    ),
                                    style = TextStyle(
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        color = Color.Black.copy(
                                            0.7f
                                        )
                                    ),
                                )
                            }

                        }
                    }
                    if (it == 1) {
                        Box(modifier = Modifier
                            .size(5.dp)
                            .graphicsLayer {
                                shape = RoundedCornerShape(10.dp)
                                clip = true
                            }
                            .background(
                                Dark_Blue)
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
    FilterBox()
}