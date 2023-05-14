package com.example.ecomdemo.screen.states

data class UserSignUpUiState (
    val firstName: String = "",
    val secondName: String = "",
    val contact: String = "",
    val email: String = "",
    val showAlert: Boolean = false,
    val message: String = "",
)