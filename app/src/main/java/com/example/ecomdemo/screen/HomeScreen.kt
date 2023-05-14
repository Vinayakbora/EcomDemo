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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.R
import com.example.ecomdemo.Routes
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
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth()
        )
        Row {
            IconButton(
                onClick = { navController.navigate(Routes.Order.route) }
            ) {
                Image(
                    painter = painterResource(R.drawable.orders),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(16.dp)
                )
            }
            IconButton(
                onClick = { navController.navigate(Routes.Cart.route) }
            ) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(16.dp)
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
                        modifier = Modifier
                            .padding(16.dp)
                            .size(50.dp)
                    )
                    Column {
                        product.name?.let {
                            Text(
                                text = it,
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(0.dp, 16.dp, 20.dp, 10.dp)
                            )
                        }
                        product.description?.let {
                            Text(
                                text = it,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(vertical = 16.dp)
                                    .width(110.dp)
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
