package com.example.ecomdemo.screen.states

data class LoginUiState(
    var contact: String = "",
    val showAlert: Boolean = false,
    val message: String = ""
)
