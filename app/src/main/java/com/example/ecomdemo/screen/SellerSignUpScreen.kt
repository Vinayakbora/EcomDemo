package com.example.ecomdemo.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.common.OSTextField
import com.example.ecomdemo.screen.events.SellerSignUpUiEvent
import com.example.ecomdemo.screen.states.SellerSignUpUiState
import com.example.ecomdemo.common.OSButton
import com.example.ecomdemo.ui.theme.SELLER_SUCCESS_MESSAGE

@Composable
fun SellerSignUpScreen(
    navController: NavHostController,
    state: SellerSignUpUiState = SellerSignUpUiState(),
    onEvent: (SellerSignUpUiEvent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state.showAlert)
            AlertDialog(
                title = { Text(text = "Alert") },
                text = { Text(text = state.message) },
                onDismissRequest = { onEvent(SellerSignUpUiEvent.DismissAlertDialog) },
                confirmButton = {
                    TextButton(onClick = {
                        if (state.message == SELLER_SUCCESS_MESSAGE) {
                            onEvent(SellerSignUpUiEvent.InsertSeller)
                            navController.popBackStack()
                        } else {
                            onEvent(SellerSignUpUiEvent.DismissAlertDialog)
                        }
                    }) { Text(text = "OK") }
                },
            )

        Text(text = "Seller Sign Up", style = TextStyle(fontSize = 40.sp))

        OSTextField(
            value = state.name,
            onValueChange = { onEvent(SellerSignUpUiEvent.OnNameChanged(it)) },
            label = "Seller Name",
            keyboardType = KeyboardType.Text
        )

        OSTextField(
            value = state.contact,
            onValueChange = { onEvent(SellerSignUpUiEvent.OnContactChanged(it)) },
            label = "Contact",
            keyboardType = KeyboardType.Phone
        )

        OSTextField(
            value = state.address,
            onValueChange = { onEvent(SellerSignUpUiEvent.OnAddressChanged(it)) },
            label = "Address",
            keyboardType = KeyboardType.Text
        )

        OSButton(
            onClick = { onEvent(SellerSignUpUiEvent.OnSignUpClicked) },
            text = "Sign Up"
        )
    }
}