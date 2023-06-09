package com.example.ecomdemo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.R
import com.example.ecomdemo.Routes
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.viewmodels.MainViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel,
) {
    Column {
        TopBar(navController)
        ProductList(navController = navController, mainViewModel)
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "PRODUCTS",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = BlueGrotto,
            style = TextStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic),
            modifier = Modifier.padding(16.dp).wrapContentWidth()
        )
        Row {
            IconButton(
                onClick = { navController.navigate(Routes.Order.route) },
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.tick),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(BlueGrotto),
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(
                onClick = { navController.navigate(Routes.Cart.route) },
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = null,
                    tint = BlueGrotto,
                    modifier = Modifier.size(35.dp)
                )
            }
            IconButton(
                onClick = { navController.navigate(Routes.LoginScreen.route){
                    popUpTo(Routes.Home.route) { inclusive = true }
                    launchSingleTop = true }
                },
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(BlueGrotto),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Composable
fun ProductList(
    navController: NavHostController,
    mainViewModel: MainViewModel,
) {
    val allProducts = mainViewModel._productListState.value!!
    LazyColumn {
        items(allProducts) { product ->
            Card(
                elevation = 3.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
                    .clickable { navController.navigate("${Routes.PDP.route}/${product.name}") }
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.mobile),
                        contentDescription = "Product",
                        modifier = Modifier.padding(16.dp).size(50.dp)
                    )
                    Column(modifier = Modifier.width(150.dp)) {
                        product.name?.let {
                            Text(
                                text = it,
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(vertical = 15.dp).fillMaxWidth()
                            )
                        }
                        product.description?.let {
                            Text(
                                text = it,
                                fontSize = 12.sp,
                                style = TextStyle(fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif),
                                modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth()
                            )
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "₹${product.price.toInt()}",
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(16.dp)
                        )
                        Button(
                            onClick = {
                                if (!mainViewModel.cartItems.contains(product)) {
                                    mainViewModel.totalPrice.value =
                                        mainViewModel.totalPrice.value + product.price
                                    product.updateQuantity(1)
                                    mainViewModel.cartItems.add(product)
                                }
                            },
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Text(text = "Add", fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}
