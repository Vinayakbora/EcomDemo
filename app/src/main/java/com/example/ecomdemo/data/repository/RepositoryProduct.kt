package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.Product
import kotlinx.coroutines.flow.Flow

interface RepositoryProduct {

    fun getAllProduct(): Flow<List<Product>>

    suspend fun insertProduct(product: Product): Long

    suspend fun deleteProduct(product: Product): Int

    suspend fun updateProduct(product: Product)

    suspend fun getProductById(productId: Long): Product
}