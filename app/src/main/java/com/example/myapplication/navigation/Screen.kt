package com.example.myapplication.navigation

/**
 * A sealed class to define all unique navigation routes of this app.
 * @param route
 * @param resourceId
 */
sealed class Screen(val route: String, val name: String) {
    object Home : Screen("home_screen", "Home")
    object Explorer : Screen("explorer_screen", "Explorer")
    object Support : Screen("support_screen", "Urgent")
    object User : Screen("user_screen", "User")
    object CardDetail : Screen("card_detail", "CardDetail")
}