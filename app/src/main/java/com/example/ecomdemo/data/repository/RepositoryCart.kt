package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.Cart
import kotlinx.coroutines.flow.Flow

interface RepositoryCart {

    fun getAllCart(): Flow<List<Cart>>

    suspend fun insertCart(cart: Cart): Long

    suspend fun deleteCart(cart: Cart): Int

    suspend fun updateCart(cart: Cart)

    suspend fun getCartById(cartId: Long): Cart
}