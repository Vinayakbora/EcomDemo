package com.example.ecomdemo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdemo.model.Product
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.LightGreen1

@Composable
fun OrdersScreen(products: MutableList<Product>) {
    Column {
        OrderBar()
        OrderSummary(products)
    }
}

@Composable
fun OrderBar() {
    Row(
        Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "MY ORDERS",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = BlueGrotto,
            style = TextStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic),
            modifier = Modifier.padding(16.dp).wrapContentWidth()
        )
    }
}

@Composable
fun OrderSummary(products: MutableList<Product>) {
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
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(10.dp).width(100.dp)
                        )
                        Text(
                            text = product.price,
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Text(
                        text = "DELIVERED",
                        textAlign = TextAlign.End,
                        fontSize = 15.sp,
                        style = TextStyle(fontWeight = FontWeight.Bold, color = LightGreen1),
                        modifier = Modifier
                            .padding(16.dp)
                            .wrapContentWidth()
                    )
                }
            }
        }
    }
}

