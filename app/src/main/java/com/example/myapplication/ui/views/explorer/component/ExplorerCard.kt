package com.example.myapplication.ui.views.explorer.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.common.filterBox.FilterBox
import com.example.myapplication.R
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.theme.Blue_Icon
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Dark_Red
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.theme.Soft_Blue
import com.example.myapplication.ui.theme.White_Color

@Composable
internal fun ExplorerCard(
    modifier: Modifier = Modifier,
    actions: MainActions
) {

    Box(
        modifier = modifier
            .graphicsLayer {
                shape = RoundedCornerShape(8.dp)
                clip = true
            }
            .clickable {
                actions.gotoFeedDetail.invoke()
            },
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(
                15.dp
            ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.card_image),
                contentDescription = "Image",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .graphicsLayer {
                        shape =
                            RoundedCornerShape(15.dp)
                        clip = true
                    },
                contentScale = ContentScale.Crop
            )
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                CustomText(
                    text = "Urgent! Help the construction mosque",
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Dark_Blue
                    )
                )
                Row(
                    Modifier.padding(top = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        5.dp
                    )
                ) {
                    CustomText(
                        text = "Jacky Man",
                        textAlign = TextAlign.Start,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Dark_Blue
                        )
                    )

                    Icon(
                        painter = painterResource(
                            id = R.drawable.checkmark
                        ),
                        contentDescription = "",
                        tint = Blue_Icon,
                    )
                }

                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 17.dp),
                    progress = 0.7f,
                    backgroundColor = Soft_Blue,
                    color = Dark_Blue,
                    strokeCap = StrokeCap.Round
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomText(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Dark_Red,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            ) {
                                append("$ 132.00")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Gray,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append(" funded ")
                            }
                        },
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.width(
                            100.dp
                        ),
                        maxLines = 1
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomText(
                            text = "• ",
                            style = TextStyle(
                                fontSize = 8.sp,
                                textAlign = TextAlign.Center,
                                color = Color.Red
                            )
                        )
                        CustomText(
                            text = "31 days left",
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Gray
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
    ExplorerCard(
        actions = MainActions(
            navController
        )
    )
}