package com.example.ecomdemo.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.Routes
import com.example.ecomdemo.common.Validation
import com.example.ecomdemo.ui.theme.Purple700

@Composable
fun LoginPage(navController: NavHostController) {

    val validation = Validation()
    var isNumValid: Boolean
    var isPassValid: Boolean

    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { navController.navigate(Routes.SignUpOption.route) },
            style = TextStyle(
                fontSize = 14.sp, textDecoration = TextDecoration.Underline, color = Purple700
            )
        )
    }
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val mobileNumber = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Text(text = "Login", style = TextStyle(fontSize = 40.sp))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(label = { Text(text = "Mobile Number") },
            value = mobileNumber.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            onValueChange = { mobileNumber.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(label = { Text(text = "Password") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        val selectedOption = remember { mutableStateOf("") }
        var isOptionSelected by remember { mutableStateOf(false) }

        Row(modifier = Modifier.padding(0.dp, 10.dp, 20.dp, 0.dp)) {
            RadioButton(selected = selectedOption.value == "User", onClick = {
                selectedOption.value = "User"
                isOptionSelected = true
            })
            Text(text = "User", modifier = Modifier.padding(0.dp, 13.dp, 0.dp, 0.dp))

            Spacer(modifier = Modifier.size(15.dp))

            RadioButton(selected = selectedOption.value == "Seller", onClick = {
                selectedOption.value = "Seller"
                isOptionSelected = true
            })
            Text(text = "Seller", modifier = Modifier.padding(0.dp, 13.dp, 0.dp, 0.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    isNumValid = validation.validatePhone(mobileNumber.value.text)
                    isPassValid = validation.validatePass(password.value.text)

                    if (isNumValid && isPassValid && isOptionSelected) {
                        navController.navigate(Routes.Home.route){
                            popUpTo(Routes.Login.route) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }
    }

}