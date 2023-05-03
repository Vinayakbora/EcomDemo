package com.example.ecomdemo

sealed class Routes(val route: String) {
    object Login : Routes("Login")

    object SignUp : Routes("SignUp")

    object Home : Routes("Home")

    object Cart : Routes("Cart")

    object Order : Routes("Order")

}
