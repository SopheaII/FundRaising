package com.example.myapplication.ui.views.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.example.myapplication.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Soft_Blue

@Composable
internal fun FeedCard(
    modifier: Modifier = Modifier,
    actions: MainActions
) {
    Card(
        modifier = modifier
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(8.dp),
                clip = true
            )
            .clickable {
                actions.gotoFeedDetail.invoke()
            }, shape = RoundedCornerShape(8.dp)

    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(
                top = 16.dp,
                start = 15.dp,
                end = 15.dp,
                bottom = 10.dp
            )
        ) {

            // Common FeadCard
            CommonFeedCard()

            // Bottom container
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    elevation = null,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.ic_support
                            ),
                            contentDescription = "",
                            tint = Dark_Blue
                        )
                        CustomText(
                            text = "1k",
                            modifier = Modifier.padding(
                                start = 5.dp
                            ),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                    elevation = null
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.ic_share
                            ),
                            contentDescription = "",
                            tint = Dark_Blue
                        )
                        CustomText(
                            text = "Share",
                            modifier = Modifier.padding(
                                start = 5.dp
                            ),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.weight(
                        1f
                    )
                )
                Button(onClick = {},
                    modifier = Modifier
                        .graphicsLayer {
                            shape =
                                RoundedCornerShape(
                                    10.dp
                                )
                            clip = true
                        }
                        .width(113.dp)
                        .height(36.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Soft_Blue
                    )) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            5.dp
                        )
                    ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.ic_heard
                            ),
                            contentDescription = "",
                            tint = Dark_Blue
                        )
                        CustomText(
                            text = "Saved",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Dark_Blue
                            )
                        )

                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun FeedCardPreview(
) {
    val navController = rememberNavController()
    FeedCard(actions = MainActions(navController))
}