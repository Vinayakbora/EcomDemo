package com.example.ecomdemo.model

import androidx.annotation.DrawableRes

data class Product(
    val name: String,
    val details: String,
    val price: String,
    @DrawableRes val imageId: Int
)
