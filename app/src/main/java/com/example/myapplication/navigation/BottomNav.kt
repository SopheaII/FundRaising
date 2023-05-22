package com.example.myapplication.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.get
import com.example.myapplication.common.CustomText
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Soft_Blue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.navigation.navigateTo
import kotlinx.coroutines.launch
import androidx.activity.OnBackPressedCallback
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.shadow
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.theme.White_Color
import com.example.myapplication.ui.views.home.component.CommonFeedCard

@ExperimentalAnimationApi
@Composable
fun BottomNav(
    navController: NavController
) {
    val currentDestination = remember {
        mutableStateOf(Screen.Home.route)
    }

    val bottomBarState =
        rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    when (navBackStackEntry.value?.destination?.route) {
        Screen.Home.route, Screen.User.route, Screen.Support.route, Screen.Explorer.route -> {
            bottomBarState.value = true
        }

        else -> {
            bottomBarState.value = false
        }
    }

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = {it}),
        exit = slideOutVertically(targetOffsetY = {it})
    ) {
        BottomNavigation(
            modifier = Modifier
                .height(55.dp)
                .shadow(
                    elevation = 15.dp,
//                    shape = RoundedCornerShape(10.dp),
//                    clip = true
                ),
//            elevation = 15.dp,
            backgroundColor = White_Color
        ) {
            BottomBarDestination.values()
                .forEach { destination ->
                    BottomNavigationItem(
                        selected = destination.direction == currentDestination.value,
                        onClick = {
                            currentDestination.value =
                                destination.direction
                            navController.navigate(
                                destination.direction
                            ) {
                                popUpTo(
                                    Screen.Home.route
                                ) {
                                    saveState =
                                        true
                                }
                                launchSingleTop =
                                    true

                                restoreState =
                                    true
                            }
                        },
                        icon = {
                            NavigationItemIcon(
                                destination = destination,
                                selected = destination.direction == currentDestination.value
                            )
                        },
                        unselectedContentColor = Dark_Blue,
                        selectedContentColor = Color.White
                    )
                }
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun NavigationItemIcon(
    destination: BottomBarDestination,
    selected: Boolean
) {
    if (selected) {
        Row(
            modifier = Modifier
                .height(35.dp)
                .background(
                    Dark_Blue,
                    RoundedCornerShape(8.dp)
                )
                .padding(
                    start = 15.dp,
                    end = 15.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                painter = painterResource(id = destination.icon),
                contentDescription = "",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            CustomText(
                text = destination.label,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = White_Color
                )
            )
        }
    } else {
        Box(
            modifier = Modifier
                .size(40.dp)
        ) {
            Icon(
                painter = painterResource(id = destination.icon),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(23.dp, 23.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@ExperimentalAnimationApi
@Composable
fun BottomNavPreview() {
    val navController =
        rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNav(
                navController = navController
            )
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = ""
        )
    }
}