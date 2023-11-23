package com.example.myapplication.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.common.feedCard.FeedCardDetail
import com.example.myapplication.ui.views.explorer.ExplorerScreen
import com.example.myapplication.ui.views.home.HomeScreen
import com.example.myapplication.ui.views.notification.NotificationScreen
import com.example.myapplication.ui.views.user.UserScreen

/**
 * Class generated if any Composable is annotated with `@Destination`.
 * It aggregates all [TypedDestination]s in their [NavGraph]s.
 */

@Composable
internal fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(actions)
        }
        composable(Screen.Explorer.route) {
            BackHandler(true) {

            }
            ExplorerScreen(actions)
        }
        composable(Screen.Support.route) {
            BackHandler(true) {

            }
            NotificationScreen(actions)
        }
        composable(Screen.User.route) {
            BackHandler(true) {

            }
            UserScreen(actions)
        }
        composable(Screen.CardDetail.route) {
            FeedCardDetail(actions)
        }
    }
}

/**
 * A class to define Navigation Route to All Flows of this app with the help of [NavController]
 * @param navController
 */
class MainActions(navController: NavController) {
    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }

    val gotoFeedDetail: () -> Unit = {
        navController.navigate(Screen.CardDetail.route)
    }
}