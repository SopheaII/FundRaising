package com.example.myapplication.ui.views.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.myapplication.R
import com.example.myapplication.common.CustomText
import com.example.myapplication.ui.theme.Blue_Icon
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Dark_Red
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.theme.Soft_Blue
import com.example.myapplication.ui.theme.White_Color

@Composable
internal fun CommonFeedCard() {
    Column {
        // Card header
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.user_logo
                ),
                contentDescription = "",
                modifier = Modifier.size(
                    35.dp
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Row {
                    CustomText(
                        text = "James Calzoni",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Dark_Blue
                        )
                    )
                    Icon(
                        modifier = Modifier.padding(
                            start = 5.dp
                        ),
                        painter = painterResource(
                            id = R.drawable.ic_checkmark
                        ),
                        contentDescription = "",
                        tint = Blue_Icon
                    )
                }
                CustomText(
                    text = "1.5k Followers",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Dark_Blue
                    )
                )
            }
            Spacer(Modifier.weight(1f))
            Button(onClick = {},
                modifier = Modifier
                    .graphicsLayer {
                        shape =
                            RoundedCornerShape(
                                10.dp
                            )
                        clip = true
                    }
                    .height(32.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Dark_Blue
                )) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        5.dp
                    ),
                    modifier = Modifier.padding(
                        start = 0.dp,
                        end = 0.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_emoji_face
                        ),
                        contentDescription = "",
                        tint = White_Color
                    )
                    CustomText(
                        text = "Unfollow",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = White_Color
                        )
                    )

                }
            }
        }

        // Title
        CustomText(
            modifier = Modifier.padding(top = 10.dp),
            text = "Empowering Education: Supporting education for underprivileged children or providing educational resources to disadvantaged communities.",
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Dark_Blue
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomText(
            text = "Monday, 26 September 2022",
            style = TextStyle(
                fontSize = 12.sp,
                color = Gray_Text
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Image
        Image(
            painter = painterResource(id = R.drawable.card_image),
            contentDescription = "Image",
            modifier = Modifier
                .height(200.dp)
                .graphicsLayer {
                    shape =
                        RoundedCornerShape(8.dp)
                    clip = true
                },
            contentScale = ContentScale.Crop
        )

        // Fund progress bar
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
            CustomText(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Dark_Red,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("$ 132.00")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append(" of ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Dark_Blue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("$5000.00")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append(" funded")
                }
            })

            CustomText(
                text = "31 days left",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            )
        }
    }
}

@Preview
@Composable
fun Preview(
) {
    CommonFeedCard()
}