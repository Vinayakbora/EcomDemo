package com.example.ecomdemo.screen.states

data class SellerSignUpUiState(
    val name: String = "",
    val contact: String = "",
    val address: String = "",
    val showAlert: Boolean = false,
    val message: String = "",
)