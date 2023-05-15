package com.example.ecomdemo.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.ecomdemo.Routes
import com.example.ecomdemo.common.OSButton
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.viewmodels.MainViewModel

@Composable
fun LoginScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel,
) {

    val showDialog = remember { mutableStateOf(false) }
    val alertMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val selectedOption = remember { mutableStateOf("User") }
        val mobileNumber = remember { mutableStateOf(TextFieldValue()) }

        Text(
            text = "Login",
            style = TextStyle(fontSize = 40.sp, color = BlueGrotto, fontWeight = FontWeight.Bold)
        )

        OutlinedTextField(
            label = { Text(text = "Mobile Number", color = BlueGrotto) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = BlueGrotto,
                focusedBorderColor = BlueGrotto,
                unfocusedBorderColor = BlueGrotto
            ),
            value = mobileNumber.value,
            modifier = Modifier.padding(vertical = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { mobileNumber.value = it })

        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            RadioButton(
                selected = selectedOption.value == "User",
                onClick = { selectedOption.value = "User" },
                enabled = true
            )

            Text(text = "User", modifier = Modifier.padding(0.dp, 15.dp, 20.dp, 15.dp))

            RadioButton(selected = selectedOption.value == "Seller",
                onClick = { selectedOption.value = "Seller" })

            Text(text = "Seller", modifier = Modifier.padding(vertical = 15.dp))
        }

        OSButton(
            onClick = {
                if (selectedOption.value == "Seller") {
                    mainViewModel._sellerExists.removeObservers(navController.context as LifecycleOwner)
                    mainViewModel._sellerExists.observe(navController.context as LifecycleOwner) { seller ->
                        if (seller != null) {
                            navController.navigate(Routes.SellerHome.route) {
                                popUpTo(Routes.LoginScreen.route) { inclusive = true }
                                launchSingleTop = true
                            }
                        } else {
                            alertMessage.value = "No such seller exists"
                            showDialog.value = true
                        }
                    }
                    mainViewModel.getSellerByContact(mobileNumber.value.text)
                } else {
                    mainViewModel._customerExists.removeObservers(navController.context as LifecycleOwner)
                    mainViewModel._customerExists.observe(navController.context as LifecycleOwner) { customer ->
                        if (customer != null) {
                            navController.navigate(Routes.Home.route) {
                                popUpTo(Routes.LoginScreen.route) { inclusive = true }
                                launchSingleTop = true
                            }
                        } else {
                            alertMessage.value = "No such customer exists"
                            showDialog.value = true
                        }
                    }
                    mainViewModel.getCustomerByPhoneNumber(mobileNumber.value.text)
                }
                mainViewModel.getAllProducts()
            },
            text = "Log In",
        )

        ClickableText(
            text = AnnotatedString("No account? Sign up here"),
            modifier = Modifier.padding(15.dp),
            onClick = { navController.navigate(Routes.SignUpOption.route) },
            style = TextStyle(
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                color = BlueGrotto
            )
        )

    }

    @Composable
    fun SimpleAlertDialog(message: String) {
        AlertDialog(onDismissRequest = { },

            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    alertMessage.value = ""
                }) { Text(text = "OK") }
            },

            title = { Text(text = "Alert") }, text = { Text(text = message) })
    }

    if (showDialog.value) {
        SimpleAlertDialog(alertMessage.value)
    }
}