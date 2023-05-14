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
import com.dev.focus.ecomdemo.screen.events.UserSignUpUiEvent
import com.example.ecomdemo.screen.states.UserSignUpUiState
import com.example.ecomdemo.common.OSButton
import com.example.ecomdemo.ui.theme.USER_SUCCESS_MESSAGE

@Composable
fun UserSignUpScreen(
    navController: NavHostController,
    state: UserSignUpUiState = UserSignUpUiState(),
    onEvent: (UserSignUpUiEvent) -> Unit,
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
                onDismissRequest = { onEvent(UserSignUpUiEvent.DismissAlertDialog) },
                confirmButton = {
                    TextButton(onClick = {
                        if (state.message == USER_SUCCESS_MESSAGE) {
                            onEvent(UserSignUpUiEvent.InsertUser)
                            navController.popBackStack()
                        } else {
                            onEvent(UserSignUpUiEvent.DismissAlertDialog)
                        }
                    }) { Text(text = "OK") }
                },
            )

        Text(text = "User Sign Up", style = TextStyle(fontSize = 40.sp))

        OSTextField(
            value = state.firstName,
            onValueChange = { onEvent(UserSignUpUiEvent.OnFirstNameChanged(it)) },
            label = "First Name",
            keyboardType = KeyboardType.Text
        )

        OSTextField(
            value = state.secondName,
            onValueChange = { onEvent(UserSignUpUiEvent.OnSecondNameChanged(it)) },
            label = "Second Name",
            keyboardType = KeyboardType.Text
        )

        OSTextField(
            value = state.contact,
            onValueChange = { onEvent(UserSignUpUiEvent.OnContactChanged(it)) },
            label = "Contact",
            keyboardType = KeyboardType.Phone
        )

        OSTextField(
            value = state.email,
            onValueChange = { onEvent(UserSignUpUiEvent.OnEmailChanged(it)) },
            label = "Email",
            keyboardType = KeyboardType.Text
        )

        OSButton(
            onClick = { onEvent(UserSignUpUiEvent.OnSignUpClicked) },
            text = "Sign Up"
        )
    }
}

