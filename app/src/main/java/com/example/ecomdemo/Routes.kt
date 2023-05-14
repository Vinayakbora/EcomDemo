package com.example.ecomdemo

sealed class Routes(val route: String) {
    object LoginScreen : Routes("Login")

    object SignUpOption : Routes("SignUpOption")

    object UserSignUp : Routes("UserSignUp")

    object UserList : Routes("UserList")

    object SellerList : Routes("SellerList")

    object UserAddress : Routes("UserAddress")

    object SellerSignUp : Routes("SellerSignUp")

    object Home : Routes("Home")

    object PDP : Routes("PDP")

    object SellerHome : Routes("SellerHome")

    object Cart : Routes("Cart")

    object Order : Routes("Order")

}
