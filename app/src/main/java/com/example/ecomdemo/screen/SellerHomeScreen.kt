package com.example.ecomdemo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.R
import com.example.ecomdemo.Routes
import com.example.ecomdemo.common.OSText
import com.example.ecomdemo.common.OSTextField
import com.example.ecomdemo.common.Validation
import com.example.ecomdemo.common.provideImageLoader
import com.example.ecomdemo.data.db.entities.Product
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.DarkGrey
import com.example.ecomdemo.ui.theme.RoseRed
import com.example.ecomdemo.ui.viewmodels.MainViewModel

@Composable
fun SellerHomeScreen(mainViewModel: MainViewModel, navController: NavHostController) {

    val showDialog = remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var categoryName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val sellerProducts = mainViewModel.sellerProductListState.value
    val imageLoader = provideImageLoader(LocalContext.current)
    var isButtonVisible by remember { mutableStateOf(true) }
    val showAlertBox = remember { mutableStateOf(false) }
    val validate = Validation()
    var isProductNameValid = false
    var isProductPriceValid = false
    var isProductCategoryValid = false
    var isProductDescriptionValid = false

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "SELLER PRODUCTS",
                fontSize = 25.sp,
                textAlign = TextAlign.Start,
                color = BlueGrotto,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(16.dp)
            )
            IconButton(
                onClick = { navController.navigate(Routes.LoginScreen.route){
                    popUpTo(Routes.SellerHome.route) { inclusive = true }
                    launchSingleTop = true }
              },
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(BlueGrotto),
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)
            ) {
                if (sellerProducts != null) {
                    items(sellerProducts.product) { product ->
                        ProductItem(product)
                    }
                }
            }

            if (isButtonVisible) {
                FloatingActionButton(
                    onClick = {
                        showDialog.value = true
                        isButtonVisible = false
                    },
                    backgroundColor = BlueGrotto,
                    contentColor = Color.White,
                    modifier = Modifier
                        .padding(24.dp)
                        .align(Alignment.BottomEnd)
                        .size(64.dp)
                ) {
                    Icon(Icons.Filled.Add, "")
                }
            }
        }

        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                    isButtonVisible = true
            },
                confirmButton = {
                    Button(onClick = {
                        if (isProductNameValid && isProductPriceValid && isProductCategoryValid
                            && isProductDescriptionValid) {
                            mainViewModel.addProduct(
                                name, price.toDoubleOrNull() ?: 0.0, categoryName, description
                            )
                            showDialog.value = false
                            isButtonVisible = true
                        } else {
                            showAlertBox.value = true
                        }
                    },
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)) {
                            Text("Add")
                    }
            },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                            isButtonVisible = true
                        }, modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                    ) {
                        Text("Cancel")
                    }
            },
                text = { Column(Modifier.wrapContentHeight()) {
                    Text(
                        text = "Add New Product",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        color = BlueGrotto,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .padding(horizontal = 5.dp, vertical = 13.dp)
                            .wrapContentWidth()
                    )
                    OSTextField(
                        value = name,
                        onValueChange = {
                            name = it
                            isProductNameValid = validate.validateProductName(it)
                        },
                        label = "Product Name",
                        keyboardType = KeyboardType.Text,
                        trailingImageRes = R.drawable.responsive,
                        imageLoader = imageLoader,
                    )
                    OSTextField(
                        value = price,
                        onValueChange = {
                            price = it
                            isProductPriceValid = validate.validateProductPrice(it)
                        },
                        label = "Price",
                        keyboardType = KeyboardType.Number,
                        trailingImageRes = R.drawable.money_bag,
                        imageLoader = imageLoader
                    )
                    OSTextField(
                        value = categoryName,
                        onValueChange = {
                            categoryName = it
                            isProductCategoryValid = validate.validateProductCategory(it)
                        },
                        label = "Category Name",
                        keyboardType = KeyboardType.Text,
                        trailingImageRes = R.drawable.storage,
                        imageLoader = imageLoader
                    )
                    OSTextField(
                        value = description,
                        onValueChange = {
                            description = it
                            isProductDescriptionValid = validate.validateProductDescription(it)
                        },
                        label = "Description",
                        keyboardType = KeyboardType.Text,
                        trailingImageRes = R.drawable.list,
                        imageLoader = imageLoader
                    )
                }
            })
        }
    }

    @Composable
    fun SimpleAlertDialog() {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {
                    showAlertBox.value = false
                }) {
                    Text(
                        text = "OK",
                        fontSize = 15.sp,
                        color = RoseRed,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            },
            title = { Text(
                text = "Invalid Operations",
                fontSize = 20.sp,
                color = RoseRed,
                style = TextStyle(fontWeight = FontWeight.Bold))
            },
            text = { Text(
                text = "All input fields should be filled",
                fontSize = 15.sp,
                color = DarkGrey,
                style = TextStyle(fontWeight = FontWeight.Bold))
            }
        )
    }

    if (showAlertBox.value) {
        SimpleAlertDialog()
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                Modifier.fillMaxWidth().wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OSText(
                    text = "Product Name: ",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start
                )
                OSText(
                    text = product.name ?: "",
                    style = TextStyle(fontWeight = FontWeight.Normal),
                    textAlign = TextAlign.End
                )
            }
            Row(
                Modifier.fillMaxWidth().wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OSText(
                    text = "Product Price: ",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start
                )
                OSText(
                    text = "₹${product.price}",
                    style = TextStyle(fontWeight = FontWeight.Normal),
                    textAlign = TextAlign.End
                )
            }
            Row(
                Modifier.fillMaxWidth().wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OSText(
                    text = "Product Category: ",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start
                )
                OSText(
                    text = product.categoryName ?: "",
                    style = TextStyle(fontWeight = FontWeight.Normal),
                    textAlign = TextAlign.End
                )
            }
            Row(
                Modifier.fillMaxWidth().wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OSText(
                    text = "Product Description: ",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start
                )
                OSText(
                    text = product.description ?: "",
                    style = TextStyle(fontWeight = FontWeight.Normal),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
