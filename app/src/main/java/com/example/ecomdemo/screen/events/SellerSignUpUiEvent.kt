package com.example.ecomdemo.screen.events

sealed class SellerSignUpUiEvent {
    data class OnNameChanged(val name: String) : SellerSignUpUiEvent()
    data class OnContactChanged(val contact: String) : SellerSignUpUiEvent()
    data class OnAddressChanged(val address: String) : SellerSignUpUiEvent()
    object OnSignUpClicked : SellerSignUpUiEvent()
    object InsertSeller: SellerSignUpUiEvent()
    object DismissAlertDialog : SellerSignUpUiEvent()
}
