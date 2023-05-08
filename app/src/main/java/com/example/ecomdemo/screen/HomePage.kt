package com.example.ecomdemo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.Routes
import com.example.ecomdemo.model.Product


@Composable
fun HomePage(navController: NavHostController, products: MutableList<Product>){
    Column {
        TopBar(navController)
        ProductList(products)
    }
}
@Composable
fun TopBar(navController: NavHostController){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "PRODUCTS",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(16.dp).wrapContentWidth()
        )
        IconButton(
            onClick = { navController.navigate(Routes.Cart.route)  }
        ) {
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(64.dp).padding(16.dp))
        }
    }
}
@Composable
fun ProductList(products: MutableList<Product>) {

    LazyColumn {
        items(products) { product ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = product.imageId),
                        contentDescription = "Product",
                        modifier = Modifier.padding(16.dp)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = product.name,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(0.dp,16.dp,20.dp,10.dp)
                        )
                        Text(
                            text = product.details,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(16.dp)
                                .width(110.dp)
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(
                            text = product.price,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(16.dp)
                        )
                        Button(onClick = {}, modifier = Modifier.padding(5.dp)) {
                                Text(text = "Add",fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}
