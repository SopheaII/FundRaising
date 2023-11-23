package com.example.myapplication.ui.views.notification.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Gray_Text

@Composable
fun notificationCard(
    modifier: Modifier  = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_profile),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(45.dp)
                .width(45.dp)
        )
        Column(
            modifier = Modifier.padding(start = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(
                5.dp
            )
        ) {
            CustomText(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Dark_Blue,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    ) {
                        append("Amanda hydenson")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append(" commented on the status on your")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Dark_Blue,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    ) {
                        append(" Fundraising for rural area.")
                    }
                },
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                maxLines = 2
            )

            CustomText(
                text = "Mon at 5:46 pm",
                style = TextStyle(fontSize = 12.sp, color = Gray_Text)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
//    val navController =
//        rememberNavController()
    notificationCard()
}