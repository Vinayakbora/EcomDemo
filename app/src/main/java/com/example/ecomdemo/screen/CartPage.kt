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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdemo.model.Product
import com.example.ecomdemo.ui.theme.DarkGrey
import com.example.ecomdemo.ui.theme.LightGreen2
import com.example.ecomdemo.ui.theme.RoseRed


@Composable
fun CartPage(products: MutableList<Product>) {
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
fun ProductSummary(products: MutableList<Product>) {

    LazyColumn(contentPadding = PaddingValues(bottom = 200.dp)) {
        items(products) { product ->
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

                        var count by remember { mutableStateOf(1) }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            OutlinedButton(
                                onClick = { if (count > 1) count-- },
                                border = BorderStroke(1.dp, RoseRed),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = RoseRed),
                                modifier= Modifier.size(36.dp),
                                shape = CircleShape,
                                contentPadding = PaddingValues(0.dp)
                            ){
                                Text(
                                    text = "-",
                                    fontSize = 16.sp,
                                    color = DarkGrey
                                )
                            }
                            Text(
                                text = count.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            OutlinedButton(
                                onClick = { if (count < 10) count++ },
                                border = BorderStroke(1.dp, LightGreen2),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = LightGreen2),
                                modifier= Modifier.size(36.dp),
                                shape = CircleShape,
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 16.sp,
                                    color = DarkGrey
                                )
                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = { products.remove(product) }) {
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