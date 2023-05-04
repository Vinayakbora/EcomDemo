package com.example.ecomdemo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdemo.model.Product


@Composable
fun CartPage(products: List<Product>) {
    Scaffold(bottomBar = { CartSummary() }) {
        it.calculateBottomPadding()
        Column {
            CartBar()
            ProductSummary(products)
            CartSummary()
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
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth()
        )
    }
}

@Composable
fun ProductSummary(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            Card(
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
                        painter = painterResource(id = product.imageId),
                        contentDescription = "Product",
                        modifier = Modifier.padding(16.dp)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = product.name,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(0.dp, 16.dp, 20.dp, 10.dp)
                        )

                        var isAddButtonVisible by remember { mutableStateOf(true) }
                        var count by remember { mutableStateOf(0) }

                        Button(
                            onClick = {
                                if (isAddButtonVisible) {
                                    count++
                                } else {
                                    if (count > 0) count--
                                }
                                isAddButtonVisible = count < 1
                            }, modifier = Modifier
                                .height(48.dp)
                                .width(108.dp)
                        ) {
                            if (isAddButtonVisible) {
                                Text(text = "1", fontSize = 12.sp)
                            } else {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    IconButton(
                                        onClick = { if (count > 0) count-- },
                                        modifier = Modifier
                                            .height(36.dp)
                                            .width(36.dp)
                                    ) {
                                        Icon(Icons.Filled.Close, null)
                                    }
                                    Text(text = count.toString())
                                    IconButton(onClick = { count++ },
                                        modifier = Modifier
                                            .height(36.dp)
                                            .width(36.dp)
                                    ) {
                                        Icon(Icons.Filled.Add, null)
                                    }
                                }
                            }
                        }

                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete")
                        }
                        Text(
                            text = product.price,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CartSummary() {
    Box(
        contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()
    ) {
        Card(
            elevation = 8.dp, modifier = Modifier
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
                        text = "₹500",
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