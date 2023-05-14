package com.example.ecomdemo.screen.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomdemo.data.db.entities.Seller
import com.example.ecomdemo.screen.events.LoginUiEvent
import com.example.ecomdemo.screen.states.LoginUiState
import com.example.ecomdemo.data.repository.RepositoryCustomer
import com.example.ecomdemo.data.repository.RepositorySeller
import com.example.ecomdemo.ui.theme.LOGIN_SUCCESS_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repositorySeller: RepositorySeller,
    private val repositoryCustomer: RepositoryCustomer,
) : ViewModel() {

    val state = mutableStateOf(LoginUiState())
    private var seller = Seller()

    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.OnContactChanged -> {
                state.value = state.value.copy(contact = event.contact)
            }
            LoginUiEvent.OnLoginClicked -> onLoginClicked()
            LoginUiEvent.DismissAlertDialog -> {
                state.value = state.value.copy(showAlert = false)
            }
        }
    }

    private fun onLoginClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            seller = getSellerByContact()
            state.value = state.value.copy(
                showAlert = true,
                message = LOGIN_SUCCESS_MESSAGE
            )
        }
    }

    private suspend fun getSellerByContact(): Seller {
        return repositorySeller.getSellerByContact(state.value.contact)
    }
}