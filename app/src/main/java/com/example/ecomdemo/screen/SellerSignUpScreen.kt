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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecomdemo.R
import com.example.ecomdemo.common.OSButton
import com.example.ecomdemo.common.OSTextField
import com.example.ecomdemo.common.provideImageLoader
import com.example.ecomdemo.screen.events.SellerSignUpUiEvent
import com.example.ecomdemo.screen.states.SellerSignUpUiState
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.DarkGrey
import com.example.ecomdemo.ui.theme.SELLER_SUCCESS_MESSAGE

@Composable
fun SellerSignUpScreen(
    navController: NavHostController,
    state: SellerSignUpUiState = SellerSignUpUiState(),
    onEvent: (SellerSignUpUiEvent) -> Unit,
) {
    val imageLoader = provideImageLoader(LocalContext.current)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state.showAlert)
            AlertDialog(
                title = { Text(
                    text = "Alert",
                    fontSize = 20.sp,
                    color = DarkGrey,
                    style = TextStyle(fontWeight = FontWeight.Bold))
                 },
                text = { Text(
                    text = state.message,
                    fontSize = 15.sp,
                    color = DarkGrey,
                    style = TextStyle(fontWeight = FontWeight.Normal))
                 },
                onDismissRequest = { onEvent(SellerSignUpUiEvent.DismissAlertDialog) },
                confirmButton = {
                    TextButton(onClick = {
                        if (state.message == SELLER_SUCCESS_MESSAGE) {
                            onEvent(SellerSignUpUiEvent.InsertSeller)
                            navController.popBackStack()
                        } else {
                            onEvent(SellerSignUpUiEvent.DismissAlertDialog)
                        }
                    }) {
                        Text(
                            text = "OK",
                            fontSize = 15.sp,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                    }
                },
            )

        Text(
            text = "Seller Sign Up",
            style = TextStyle(fontSize = 40.sp, color = BlueGrotto, fontWeight = FontWeight.Bold)
        )

        OSTextField(
            value = state.name,
            onValueChange = { onEvent(SellerSignUpUiEvent.OnNameChanged(it)) },
            label = "Seller Name",
            keyboardType = KeyboardType.Text,
            trailingImageRes = R.drawable.face_scan,
            imageLoader = imageLoader
        )

        OSTextField(
            value = state.contact,
            onValueChange = { onEvent(SellerSignUpUiEvent.OnContactChanged(it)) },
            label = "Contact",
            keyboardType = KeyboardType.Phone,
            trailingImageRes = R.drawable.phone,
            imageLoader = imageLoader
        )

        OSTextField(
            value = state.address,
            onValueChange = { onEvent(SellerSignUpUiEvent.OnAddressChanged(it)) },
            label = "Address",
            keyboardType = KeyboardType.Text,
            trailingImageRes = R.drawable.home,
            imageLoader = imageLoader
        )

        OSButton(
            onClick = { onEvent(SellerSignUpUiEvent.OnSignUpClicked) },
            text = "Sign Up"
        )
    }
}