package com.example.ecomdemo.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdemo.R
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.DarkGrey
import com.example.ecomdemo.ui.theme.LightGreen2
import com.example.ecomdemo.ui.theme.RoseRed
import com.example.ecomdemo.ui.viewmodels.MainViewModel

@Composable
fun CartScreen(mainViewModel: MainViewModel) {
    Scaffold(bottomBar = { CartSummary(mainViewModel) }) {
        it.calculateBottomPadding()
        Column {
            CartBar()
            ProductSummary(mainViewModel)
            CartSummary(mainViewModel)
        }
    }
}

@Composable
fun CartBar() {
    Row(
        Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "MY CART",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = BlueGrotto,
            style = TextStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic),
            modifier = Modifier.padding(16.dp).wrapContentWidth()
        )
    }
}

@Composable
fun ProductSummary(mainViewModel: MainViewModel) {

    val cartProducts = mainViewModel.cartItems

    LazyColumn(contentPadding = PaddingValues(bottom = 200.dp)) {
        items(cartProducts) { product ->
            Card(
                elevation = 3.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.mobile),
                        contentDescription = "Product",
                        modifier = Modifier.padding(16.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.wrapContentHeight().padding(16.dp)
                    ) {
                        product.name?.let {
                            Text(
                                text = it,
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 10.dp)
                                    .width(100.dp)
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            OutlinedButton(
                                onClick = {
                                    mainViewModel.totalPrice.value =
                                        mainViewModel.totalPrice.value - product.price
                                    when {
                                        product.quantity > 1 -> {
                                            product.decreaseQuantity()
                                        }
                                        product.quantity == 1 -> {
                                            cartProducts.remove(product)
                                        }
                                    }
                                },
                                border = BorderStroke(1.dp, RoseRed),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = RoseRed),
                                modifier = Modifier.size(36.dp),
                                shape = CircleShape,
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text(
                                    text = "-", fontSize = 16.sp, color = DarkGrey
                                )
                            }
                            Text(
                                text = product.mutableQuantity.value.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            OutlinedButton(
                                onClick = {
                                    mainViewModel.totalPrice.value =
                                        mainViewModel.totalPrice.value + product.price
                                    when {
                                        product.quantity < 10 -> product.increaseQuantity()
                                    }
                                },
                                border = BorderStroke(1.dp, LightGreen2),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = LightGreen2),
                                modifier = Modifier.size(36.dp),
                                shape = CircleShape,
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text(
                                    text = "+", fontSize = 16.sp, color = DarkGrey
                                )
                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = {
                            mainViewModel.totalPrice.value =
                                mainViewModel.totalPrice.value - (product.price * product.quantity)
                            product.updateQuantity(0)
                            cartProducts.remove(product)
                        }
                        ) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete")
                        }
                        Text(
                            text = "₹${product.price.toInt()}",
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(10.dp).wrapContentWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CartSummary(mainViewModel: MainViewModel) {
    Box(
        contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)

        ) {
            Column {
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Order Total: ",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 10.dp)
                    )
                    Text(
                        text = "₹${mainViewModel.totalPrice.value}",
                        fontSize = 20.sp,
                        textAlign = TextAlign.End,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 10.dp)
                    )
                }
                Box(modifier = Modifier.padding(40.dp, 20.dp, 40.dp, 20.dp)) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Proceed to Checkout")
                    }
                }
            }
        }
    }
}