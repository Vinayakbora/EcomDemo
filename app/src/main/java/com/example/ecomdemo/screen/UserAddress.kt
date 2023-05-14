package com.example.ecomdemo.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.Routes
import com.example.ecomdemo.common.Validation

@Composable
fun UserAddress(navController: NavHostController) {

    val validation = Validation()
    var isAddress1Valid: Boolean
    var isAddress2Valid: Boolean
    var isAddress3Valid: Boolean
    var isPincodeValid: Boolean

    Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val address1 = remember { mutableStateOf(TextFieldValue()) }
        val address2 = remember { mutableStateOf(TextFieldValue()) }
        val address3 = remember { mutableStateOf(TextFieldValue()) }
        val pinCode = remember { mutableStateOf(TextFieldValue()) }

        Text(text = "User Address", style = TextStyle(fontSize = 40.sp))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "House No., Building Name") },
            value = address1.value,
            onValueChange = { address1.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Road Name, Area, Colony") },
            value = address2.value,
            onValueChange = { address2.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "City, State, Country") },
            value = address3.value,
            onValueChange = { address3.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Pincode") },
            value = pinCode.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { pinCode.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    isAddress1Valid = validation.validateAddress1(address1.value.text)
                    isAddress2Valid = validation.validateAddress2(address2.value.text)
                    isAddress3Valid = validation.validateAddress3(address3.value.text)
                    isPincodeValid = validation.validatePincode(pinCode.value.text)

                    if(isAddress1Valid && isAddress2Valid && isAddress3Valid && isPincodeValid){
                        navController.navigate(Routes.LoginScreen.route){
                            popUpTo(Routes.UserAddress.route) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Sign Up")
            }
        }
    }
}