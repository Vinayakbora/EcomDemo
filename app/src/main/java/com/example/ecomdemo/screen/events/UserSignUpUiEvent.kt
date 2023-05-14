package com.dev.focus.ecomdemo.screen.events

sealed class UserSignUpUiEvent {
    data class OnFirstNameChanged(val firstname: String) : UserSignUpUiEvent()
    data class OnSecondNameChanged(val secondName: String) : UserSignUpUiEvent()
    data class OnContactChanged(val contact: String) : UserSignUpUiEvent()
    data class OnEmailChanged(val email: String) : UserSignUpUiEvent()
    object OnSignUpClicked : UserSignUpUiEvent()
    object InsertUser: UserSignUpUiEvent()
    object DismissAlertDialog : UserSignUpUiEvent()
}