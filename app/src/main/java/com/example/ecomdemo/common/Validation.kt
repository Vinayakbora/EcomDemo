package com.example.ecomdemo.common

import java.util.regex.Pattern

class Validation {

    private val nameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$"
    private val phoneRegex = "^\\d{10}\$"
    private val emailRegex = "^[A-Za-z\\d._%+-]+@[A-Za-z\\d.-]+\\.[A-Za-z]{2,}\$"

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

    fun validateEmail(email: String): Boolean{
        return if (email.isNotEmpty()){
            Pattern.matches(emailRegex,email)
        }else {
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

    fun validateProductName(pName: String): Boolean{
        return pName.isNotEmpty()
    }

    fun validateProductPrice(pPrice: String): Boolean{
        return pPrice.isNotEmpty()
    }

    fun validateProductCategory(pCategory: String): Boolean{
        return pCategory.isNotEmpty()
    }

    fun validateProductDescription(pDescription: String): Boolean{
        return pDescription.isNotEmpty()
    }
}