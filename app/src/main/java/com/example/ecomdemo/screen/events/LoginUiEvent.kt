package com.example.ecomdemo.screen.events

sealed class LoginUiEvent {
    data class OnContactChanged(val contact: String) : LoginUiEvent()
    object OnLoginClicked : LoginUiEvent()
    object DismissAlertDialog : LoginUiEvent()
}