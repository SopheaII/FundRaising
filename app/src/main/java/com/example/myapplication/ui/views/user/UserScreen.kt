package com.example.myapplication.ui.views.user

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.common.AnimateAlignmentAsState
import com.example.myapplication.common.CustomText
import com.example.myapplication.navigation.MainActions
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.White_Color
import com.example.myapplication.ui.views.home.component.FeedCard
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Destination
@Composable
fun UserScreen(
    actions: MainActions
) {


    val coroutineScope = rememberCoroutineScope()
    val modalSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
            skipHalfExpanded = false
        )
    val scrollState = rememberScrollState()
    val defaultPofileSize = 90
    var profileState by rememberSaveable {
        mutableStateOf(
            defaultPofileSize
        )
    }
    var previosScrollPoint by rememberSaveable{
        mutableStateOf(0)
    }
    val profileSize by animateDpAsState(
        targetValue = profileState.dp
    )

    var profileSizePercentage by rememberSaveable {
        mutableStateOf(0f)
    }

    val titleTopConstrain by animateDpAsState(
        targetValue = ((profileState - 5)*(1 - profileSizePercentage*0.8)).dp
    )

    val titleStartConstrain by animateDpAsState(
        targetValue = (70*profileSizePercentage).dp
    )

    val titleAlignmentState = animateFloatAsState(
        targetValue = profileSizePercentage
    )
    val titleAlignment = remember {
        derivedStateOf {
            BiasAlignment.Horizontal(-titleAlignmentState.value)
        }
    }

    val alignment = AnimateAlignmentAsState(
        targetAlignment = BiasAlignment(-profileSizePercentage,  -profileSizePercentage)
    )

    if (scrollState.isScrollInProgress) {
        if (scrollState.value != previosScrollPoint && defaultPofileSize > scrollState.value + 40) {
            profileState =
                defaultPofileSize - scrollState.value
            profileSizePercentage = scrollState.value.toFloat() / 50
        } else if (defaultPofileSize < scrollState.value + 40) {
            profileState = 40
            profileSizePercentage = 1f
        }
        previosScrollPoint = scrollState.value
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(
            topStart = 12.dp,
            topEnd = 12.dp
        ),
        sheetContent = {
            Column(
                //...
            ) {
                //...

                Button(
                    onClick = {
                        coroutineScope.launch { modalSheetState.hide() }
                    }
                ) {
                    Text(text = "Hide Sheet")
                }
            }
        }
    ) {
        Scaffold(topBar = {
            TopAppBar(
                backgroundColor = White_Color,
                elevation = 0.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(
                        modifier = Modifier
                            .size(50.dp)
                    )

                    CustomText(
                        text = "Profile",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Dark_Blue
                        ),
                    )

                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                if (modalSheetState.isVisible)
                                    modalSheetState.hide()
                                else {
                                    modalSheetState.show()
                                }
                            }
                        }) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.ic_menu
                            ),
                            contentDescription = ""
                        )
                    }
                }
            }
        }) {
            Column(
            ) {

                // Profile Image
                Box(
                    contentAlignment = alignment,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 20.dp,
                            end = 20.dp,
                            bottom = (50 * (1 - profileSizePercentage) + 10).dp
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .height(
                                profileSize + 20.dp
                            )
                            .width(profileSize + 20.dp)
                            .graphicsLayer {
                                shape =
                                    RoundedCornerShape(
                                        50
                                    )
                                clip = true
                            }
                            .background(
                                Color.Gray.copy(
                                    0.1f
                                )
                            ),
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.user_profile
                            ),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(
                                    profileSize
                                )
                                .width(
                                    profileSize
                                )
                                .graphicsLayer {
                                    shape =
                                        RoundedCornerShape(
                                            50
                                        )
                                    clip =
                                        true
                                }
                                .clickable { }
                                .align(
                                    Alignment.Center
                                ),

                            )
                    }

                    // User Name
                    Box(
                        modifier = Modifier
                            .padding(start = titleStartConstrain)
                            .offset(y = titleTopConstrain),
                    ) {
                        Column(
                            horizontalAlignment = titleAlignment.value
                        ) {
                            CustomText(
                                text = "Jacky Man",
                                modifier = Modifier.padding(
                                    it
                                ),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Dark_Blue,
                                    textAlign = TextAlign.Center
                                )
                            )
                            CustomText(
                                text = "Cambodia ChilCharity",
                                modifier = Modifier.padding(
                                    it
                                ),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Dark_Blue
                                )
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(it)
                        .verticalScroll(
                            scrollState
                        ),
                    horizontalAlignment = Alignment.Start
                ) {
                    // Profile info
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(
                                1f
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomText(
                                text = "28",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    color = Dark_Blue,
                                    fontWeight = FontWeight.Black
                                )
                            )
                            CustomText(
                                text = "Follower",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Dark_Blue,
                                )
                            )
                        }

                        Column(
                            modifier = Modifier.weight(
                                1f
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomText(
                                text = "78",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    color = Dark_Blue,
                                    fontWeight = FontWeight.Black
                                )
                            )
                            CustomText(
                                text = "Following",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Dark_Blue,
                                )
                            )
                        }

                        Column(
                            modifier = Modifier.weight(
                                1f
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomText(
                                text = "16",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    color = Dark_Blue,
                                    fontWeight = FontWeight.Black
                                )
                            )
                            CustomText(
                                text = "Post",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Dark_Blue,
                                )
                            )
                        }
                    }

                    CustomText(
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 15.dp
                        ),
                        text = "Previous Post",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Dark_Blue,
                        )
                    )
                    // My Post
                    Box(
                        modifier = Modifier
                            .padding(
                                start = 20.dp,
                                end = 20.dp,
                                top = 15.dp
                            )
                            .fillMaxHeight()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                15.dp
                            )
                        ) {
                            for (it in 1..10) {
                                FeedCard(actions = actions)
                            }
                        }
                    }

                }
            }
        }
    }


}

@Preview
@Composable
fun Preview(
) {
    val navController = rememberNavController()
    UserScreen(MainActions(navController))
}