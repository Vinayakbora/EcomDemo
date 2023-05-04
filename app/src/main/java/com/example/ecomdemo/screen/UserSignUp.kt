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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.Routes
import com.example.ecomdemo.common.Validation

@Composable
fun UserSignUp(navController: NavHostController) {

    val validation = Validation()
    var isNameValid: Boolean
    var isNumValid: Boolean
    var isPassValid: Boolean

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    val username = remember { mutableStateOf(TextFieldValue()) }
    val mobileNumber = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    Text(text = "User Sign Up", style = TextStyle(fontSize = 40.sp))

    Spacer(modifier = Modifier.height(20.dp))
    TextField(
        label = { Text(text = "Username") },
        value = username.value,
        onValueChange = { username.value = it })

    Spacer(modifier = Modifier.height(20.dp))
    TextField(
        label = { Text(text = "Mobile Number") },
        value = mobileNumber.value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        onValueChange = { mobileNumber.value = it })

    Spacer(modifier = Modifier.height(20.dp))
    TextField(
        label = { Text(text = "Password") },
        value = password.value,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { password.value = it })

    Spacer(modifier = Modifier.height(20.dp))
    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
        Button(
            onClick = {
                isNameValid = validation.validateName(username.value.text)
                isNumValid = validation.validatePhone(mobileNumber.value.text)
                isPassValid = validation.validatePass(password.value.text)

                if(isNameValid && isNumValid && isPassValid){
                    navController.navigate(Routes.UserAddress.route){
                        popUpTo(Routes.UserSignUp.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .wrapContentWidth()
        ) {
            Text(text = "Next")
        }
    }
}

}