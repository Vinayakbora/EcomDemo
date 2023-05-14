package com.example.ecomdemo.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.ecomdemo.data.db.entities.Product
import com.example.ecomdemo.common.OSTextField
import com.example.ecomdemo.ui.viewmodels.MainViewModel

@Composable
fun SellerHomeScreen(mainViewModel: MainViewModel) {
    val showDialog = remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var categoryName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val sellerProducts = mainViewModel.sellerProductListState.value

    Column(modifier = Modifier.fillMaxSize()) {

        Button(
            onClick = { showDialog.value = true }, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Add New Product")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)
        ) {
            if (sellerProducts != null) {
                items(sellerProducts.product) { product ->
                    ProductItem(product)
                }
            }
        }

        if (showDialog.value) {
            AlertDialog(onDismissRequest = { showDialog.value = false },
                title = { Text("Add Product") },
                confirmButton = {
                    Button(onClick = {
                        mainViewModel.addProduct(
                            name, price.toDoubleOrNull() ?: 0.0, categoryName, description
                        )
                        showDialog.value = false
                    }) {
                        Text("Add")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog.value = false }) {
                        Text("Cancel")
                    }
                },
                text = {
                    Column {
                        OSTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = "Product Name",
                            keyboardType = KeyboardType.Text
                        )
                        OSTextField(
                            value = price,
                            onValueChange = { price = it },
                            label = "Price",
                            keyboardType = KeyboardType.Number
                        )
                        OSTextField(
                            value = categoryName,
                            onValueChange = { categoryName = it },
                            label = "Category Name",
                            keyboardType = KeyboardType.Text
                        )
                        OSTextField(
                            value = description,
                            onValueChange = { description = it },
                            label = "Description",
                            keyboardType = KeyboardType.Text
                        )
                    }
                })
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = product.name ?: "")
            Text(text = "₹${product.price}")
            Text(text = product.categoryName ?: "")
            Text(text = product.description ?: "")
        }
    }
}
