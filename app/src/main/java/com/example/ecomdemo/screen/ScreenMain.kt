package com.example.ecomdemo.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecomdemo.Routes

@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.SignUp.route) {
            SignUp(navController = navController)
        }

        composable(Routes.Home.route) {
            HomePage(navController = navController)
        }

        composable(Routes.Cart.route) {
            CartPage(navController = navController)
        }

        composable(Routes.Order.route) {
            OrderPage(navController = navController)
        }
    }
}