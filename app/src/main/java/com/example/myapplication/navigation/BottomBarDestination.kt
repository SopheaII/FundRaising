package com.example.myapplication.navigation
import com.example.myapplication.R

enum class BottomBarDestination(
    val direction: String,
    val icon: Int,
    val label: String
) {

    Home(Screen.Home.route, R.drawable.ic_home, "Home"),
    Explorer(Screen.Explorer.route, R.drawable.ic_exploer, "Urgent"),
    Support(Screen.Support.route, R.drawable.ic_notification, "Notification"),
    User(Screen.User.route, R.drawable.ic_user, "Users"),


}