package com.example.ecomdemo.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecomdemo.R
import com.example.ecomdemo.Routes
import com.example.ecomdemo.model.Product

const val description = "This text field will include product description"
const val details = "This text field will include product description"

@Composable
fun ScreenMain(){
    val navController = rememberNavController()
    val productList = listOf(
        Product("Fruits", description, "₹100", R.drawable.fruit),
        Product("Vegetables", description, "₹100", R.drawable.vegetables),
        Product("Meat", description, "₹100", R.drawable.meat),
        Product("Fish", description, "₹100", R.drawable.seafood),
        Product("Milk", description, "₹100", R.drawable.waterbottle),
        Product("Pastry", description, "₹100", R.drawable.pastry),
        Product("Cold Drinks", description, "₹100", R.drawable.colddrinks),
        Product("Bakery", description, "₹100", R.drawable.bakery),
        Product("Snacks", description, "₹100", R.drawable.snacks),
        Product("Eggs", description, "₹100", R.drawable.eggcarton),
    )

    val cartList = listOf(
        Product("Fruits", details, "₹100", R.drawable.fruit),
        Product("Cold Drinks", details, "₹100", R.drawable.colddrinks),
        Product("Vegetables", description, "₹100", R.drawable.vegetables),
        Product("Meat", description, "₹100", R.drawable.meat),
        Product("Fish", description, "₹100", R.drawable.seafood),
        Product("Bakery", details, "₹100", R.drawable.bakery)
    )

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.SignUpOption.route) {
            SignUpOption(navController = navController)
        }

        composable(Routes.UserSignUp.route) {
            UserSignUp(navController = navController)
        }

        composable(Routes.UserAddress.route) {
            UserAddress(navController = navController)
        }

        composable(Routes.SellerSignUp.route) {
            SellerSignUp(navController = navController)
        }

        composable(Routes.Home.route) {
            HomePage(navController = navController,productList)
        }

        composable(Routes.Cart.route) {
            CartPage(cartList)
        }

        composable(Routes.Order.route) {
            OrderPage(navController = navController)
        }
    }
}