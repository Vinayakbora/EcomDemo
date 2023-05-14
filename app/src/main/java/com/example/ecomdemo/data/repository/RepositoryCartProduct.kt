package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.relations.CartProduct
import kotlinx.coroutines.flow.Flow

interface RepositoryCartProduct {

    fun getAllCartProduct(): Flow<List<CartProduct>>

    suspend fun insertCartProduct(cartProduct: CartProduct): Long

    suspend fun deleteCartProduct(cartProduct: CartProduct): Int

    suspend fun updateCartProduct(cartProduct: CartProduct)

    suspend fun getCartProductById(id: Long): CartProduct
}