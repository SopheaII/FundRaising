package com.example.myapplication.navigation
import com.example.myapplication.R
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestination(
    val direction: String,
    val icon: Int,
    val label: String
) {

    Home(Screen.Home.route, R.drawable.home, "Home"),
    Explorer(Screen.Explorer.route, R.drawable.exploer, "Urgent"),
    Support(Screen.Support.route, R.drawable.support_bar, "Saved"),
    User(Screen.User.route, R.drawable.user, "Users"),


}