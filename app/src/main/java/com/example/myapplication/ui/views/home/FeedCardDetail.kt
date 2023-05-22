package com.example.myapplication.ui.common.feedCard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.myapplication.common.CustomText
import com.example.myapplication.R
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.theme.Blue_Icon
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Dark_Red
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.theme.Green_Text
import com.example.myapplication.ui.theme.Soft_Blue
import com.example.myapplication.ui.theme.White_Color
import com.example.myapplication.ui.views.base.ScreenHeader
import com.example.myapplication.ui.views.home.component.CommonFeedCard

@Composable
internal fun FeedCardDetail(
    actions: MainActions
) {
    Scaffold(
        topBar = {
            ScreenHeader(
                title = "Feed Detail",
                actions = actions
            )
        },
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                )
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 10.dp
                    )
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {

                // Common FeedCard
                CommonFeedCard()

                Spacer(modifier = Modifier.padding(top = 15.dp))
                CustomText(
                    text = "Empowering Education: Supporting education for underprivileged children or providing educational resources to disadvantaged communities is a charitable initiative focused on addressing educational disparities and ensuring access to quality education for all children, regardless of their socio-economic background. Here are some key details about this topic:\n" +
                            "\n" +
                            "Objective: The objective is to bridge the education gap by providing opportunities and resources to underprivileged children and communities, empowering them through education for a brighter future.\n" +
                            "\n" +
                            "Target Beneficiaries: The focus is on children from low-income families, marginalized communities, or regions with limited access to quality education. This can include children in rural areas, urban slums, refugee camps, or economically disadvantaged neighborhoods.\n" +
                            "\n" +
                            "Key Initiatives:\n" +
                            "\n" +
                            "Scholarships and Tuition Support: Providing financial assistance to cover school fees, tuition, books, and other educational expenses for deserving students who cannot afford them.\n" +
                            "Infrastructure Development: Improving school facilities, building classrooms, libraries, computer labs, and playgrounds to create conducive learning environments.\n" +
                            "Teacher Training and Support: Enhancing the skills and knowledge of teachers through training programs, workshops, and mentoring, ensuring they can deliver quality education.\n" +
                            "Educational Resources: Providing textbooks, stationery, learning materials, and technology tools to students and schools to enhance their educational experience.\n" +
                            "School Feeding Programs: Addressing the issue of hunger and malnutrition by providing nutritious meals to students, improving their health and concentration in the classroom.",
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Dark_Blue,
                    )
                )

                // Bottom container
                Spacer(modifier = Modifier.padding(top = 15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
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
                                    id = R.drawable.support
                                ),
                                contentDescription = "",
                                tint = Dark_Blue
                            )
                            CustomText(
                                text = "1k",
                                modifier = Modifier.padding(
                                    start = 5.dp
                                ),
                                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            )
                        }
                    }

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
                                    id = R.drawable.message
                                ),
                                contentDescription = "",
                                tint = Dark_Blue
                            )
                            CustomText(
                                text = "160",
                                modifier = Modifier.padding(
                                    start = 5.dp
                                ),
                                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
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
                                    id = R.drawable.share
                                ),
                                contentDescription = "",
                                tint = Dark_Blue
                            )
                            CustomText(
                                text = "Share",
                                modifier = Modifier.padding(
                                    start = 5.dp
                                ),
                                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .graphicsLayer {
                                shape =
                                    RoundedCornerShape(
                                        8.dp
                                    )
                                clip = true
                            }
                            .border(
                                BorderStroke(
                                    1.5.dp,
                                    Dark_Blue,
                                ),
                                RoundedCornerShape(
                                    8.dp
                                )
                            )
                            .width(113.dp)
                            .height(36.dp)
                            .clickable { },
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                5.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.Center)
                        ) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.head_plus
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
}

@Preview(showBackground = true)
@Composable
fun FeedCardDetailPreview() {
    val navController =
        rememberNavController()
    FeedCardDetail(
        actions = MainActions(
            navController
        )
    )
}