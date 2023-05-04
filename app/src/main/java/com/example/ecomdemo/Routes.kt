package com.example.ecomdemo

sealed class Routes(val route: String) {
    object Login : Routes("Login")

    object SignUpOption : Routes("SignUpOption")

    object UserSignUp : Routes("UserSignUp")

    object UserAddress : Routes("UserAddress")

    object SellerSignUp : Routes("SellerSignUp")

    object Home : Routes("Home")

    object Cart : Routes("Cart")

    object Order : Routes("Order")

}
