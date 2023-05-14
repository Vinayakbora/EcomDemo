package com.example.ecomdemo.screen.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomdemo.data.db.entities.Seller
import com.example.ecomdemo.screen.events.SellerSignUpUiEvent
import com.example.ecomdemo.screen.states.SellerSignUpUiState
import com.example.ecomdemo.common.Validation
import com.example.ecomdemo.data.repository.RepositorySeller
import com.example.ecomdemo.ui.theme.SELLER_SUCCESS_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SellerSignUpViewModel
@Inject constructor(
    private val repositorySeller: RepositorySeller,
) : ViewModel() {

    val state = mutableStateOf(SellerSignUpUiState())

    fun onEvent(event: SellerSignUpUiEvent) {
        when (event) {
            is SellerSignUpUiEvent.OnNameChanged -> {
                state.value = state.value.copy(name = event.name)
            }
            is SellerSignUpUiEvent.OnContactChanged -> {
                state.value = state.value.copy(contact = event.contact)
            }
            is SellerSignUpUiEvent.OnAddressChanged -> {
                state.value = state.value.copy(address = event.address)
            }
            SellerSignUpUiEvent.OnSignUpClicked -> onSignUpClicked()

            SellerSignUpUiEvent.InsertSeller -> { insertSellerIntoDatabase() }

            SellerSignUpUiEvent.DismissAlertDialog -> {
                state.value = state.value.copy(showAlert = false)
            }
        }
    }

    private fun insertSellerIntoDatabase() {
        viewModelScope.launch {
            state.value.apply {
                repositorySeller.insertSeller(
                    Seller(
                        name = name,
                        contact = contact,
                        address = address
                    )
                )
            }
            state.value = state.value.copy(showAlert = false)
        }
    }

    private fun onSignUpClicked() {
        val validation = Validation()

        val isValid = listOf(
            validation.validateName(state.value.name),
            validation.validatePhone(state.value.contact),
            validation.validateAddress1(state.value.address),
        ).all { it }

        state.value = state.value.copy(
            showAlert = true,
            message = if (isValid) SELLER_SUCCESS_MESSAGE else "Invalid Operations"
        )
    }
}