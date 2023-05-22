package com.example.ecomdemo.screen.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomdemo.data.db.entities.Customer
import com.dev.focus.ecomdemo.screen.events.UserSignUpUiEvent
import com.example.ecomdemo.screen.states.UserSignUpUiState
import com.example.ecomdemo.common.Validation
import com.example.ecomdemo.data.repository.RepositoryCustomer
import com.example.ecomdemo.ui.theme.USER_SUCCESS_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSignUpViewModel @Inject constructor(
    private val repositoryUser: RepositoryCustomer,
): ViewModel() {

    val state = mutableStateOf(UserSignUpUiState())

    fun onEvent(event: UserSignUpUiEvent) {
        when (event) {
            is UserSignUpUiEvent.OnFirstNameChanged -> {
                state.value = state.value.copy(firstName = event.firstname)
            }
            is UserSignUpUiEvent.OnSecondNameChanged -> {
                state.value = state.value.copy(secondName = event.secondName)
            }
            is UserSignUpUiEvent.OnContactChanged -> {
                state.value = state.value.copy(contact = event.contact)
            }
            is UserSignUpUiEvent.OnEmailChanged -> {
                state.value = state.value.copy(email = event.email)
            }
            UserSignUpUiEvent.OnSignUpClicked -> onSignUpClicked()

            UserSignUpUiEvent.InsertUser -> { insertUserIntoDatabase()}

            UserSignUpUiEvent.DismissAlertDialog -> {
                state.value = state.value.copy(showAlert = false)
            }
        }
    }

    private fun insertUserIntoDatabase() {
        viewModelScope.launch {
            state.value.apply {
                repositoryUser.insertCustomer(
                    Customer(
                        firstName = firstName,
                        lastName = secondName,
                        phoneNumber = contact,
                        emailId = email,
                        password = ""
                    )
                )
            }
            state.value = state.value.copy(showAlert = false)
        }
    }

    private fun onSignUpClicked() {
        val validation = Validation()

        val isValid = listOf(
            validation.validateName(state.value.firstName),
            validation.validatePhone(state.value.contact),
            validation.validateEmail(state.value.email),
        ).all { it }

        state.value = state.value.copy(
            showAlert = true,
            message = if (isValid) USER_SUCCESS_MESSAGE else "Please fill all the input fields"
        )
    }
}