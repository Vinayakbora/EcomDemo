package com.example.ecomdemo.screen

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.focus.ecomdemo.screen.*
import com.example.ecomdemo.screen.viewmodels.SellerSignUpViewModel
import com.example.ecomdemo.screen.viewmodels.UserSignUpViewModel
import com.example.ecomdemo.ui.viewmodels.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.navArgument
import com.example.ecomdemo.R
import com.example.ecomdemo.Routes
import com.example.ecomdemo.model.Product

const val description = "This text field will include product description"

@SuppressLint("UnrememberedMutableState")
@Composable
fun ScreenMain(mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    val cartList = mutableStateListOf(
        Product("iPhone 13", description, "₹70,000", R.drawable.mobile),
        Product("Google Pixel 6a", description, "₹50,000", R.drawable.mobile),
        Product("Samsung Galaxy S21", description, "₹35,000", R.drawable.mobile)
    )

    NavHost(navController = navController, startDestination = Routes.LoginScreen.route) {

        composable(Routes.LoginScreen.route) {
            LoginScreen(navController = navController, mainViewModel = mainViewModel)
        }

        composable(Routes.SignUpOption.route) {
            SignUpOption(navController = navController, mainViewModel = mainViewModel)
        }

        composable(Routes.UserSignUp.route) {
            val viewModel = hiltViewModel<UserSignUpViewModel>()
            val state = viewModel.state.value
            UserSignUpScreen(navController = navController, state = state) { event ->
                viewModel.onEvent(event)
            }
        }

        composable(Routes.UserAddress.route) {
            UserAddress(navController = navController)
        }

        composable(Routes.SellerSignUp.route) {
            val viewModel = hiltViewModel<SellerSignUpViewModel>()
            val state = viewModel.state.value
            SellerSignUpScreen(navController = navController, state = state) { event ->
                viewModel.onEvent(event)
            }
        }

        composable(Routes.Home.route) {
            HomeScreen(navController = navController, mainViewModel = mainViewModel)
        }

        composable(route = "${Routes.PDP.route}/{itemName}",
            arguments = listOf(navArgument("itemName") {
                type = NavType.StringType
            })) { backStackEntry ->
            backStackEntry.arguments?.getString("itemName")?.let { it ->
                ProductDetailsScreen(it)
            }
        }

        composable(Routes.SellerHome.route) {
            SellerHomeScreen(mainViewModel = mainViewModel)
        }

        composable(Routes.Cart.route) {
            CartScreen(mainViewModel = mainViewModel)
        }

        composable(Routes.Order.route) {
            OrdersScreen(cartList)
        }

        composable(Routes.UserList.route) {
            mainViewModel._customerListState.value?.let { customerList ->
                CustomerListScreen(customerList)
            }
        }

        composable(Routes.SellerList.route) {
            mainViewModel._sellerListState.value?.let { sellerList ->
                SellerListScreen(sellerList)
            }
        }
    }

}