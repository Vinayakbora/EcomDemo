package com.example.ecomdemo.common

import java.util.regex.Pattern

class Validation {

    private val nameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$"
    private val phoneRegex = "^\\d{10}\$"
    private val passRegex = "^.{6,}\$"

    fun validateName(name: String): Boolean{
        return if (name.isNotEmpty()) {
            Pattern.matches(nameRegex, name)
        } else {
            false
        }
    }

    fun validatePhone(phoneNumber: String): Boolean{
        return if (phoneNumber.isNotEmpty()) {
            Pattern.matches(phoneRegex, phoneNumber)
        } else {
            false
        }
    }

    fun validatePass(password: String): Boolean{
        return if (password.isNotEmpty()) {
            Pattern.matches(passRegex, password)
        } else {
            false
        }
    }

    fun validateAddress1(address1: String): Boolean{
        return address1.isNotEmpty()
    }

    fun validateAddress2(address2: String): Boolean{
        return address2.isNotEmpty()
    }

    fun validateAddress3(address3: String): Boolean{
        return address3.isNotEmpty()
    }

    fun validatePincode(pinCode: String): Boolean{
        return pinCode.isNotEmpty()
    }

}