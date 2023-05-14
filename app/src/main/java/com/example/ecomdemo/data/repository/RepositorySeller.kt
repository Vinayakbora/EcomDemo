package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.Seller
import kotlinx.coroutines.flow.Flow

interface RepositorySeller {

    fun getAllSeller(): Flow<List<Seller>>

    suspend fun insertSeller(seller: Seller): Long

    suspend fun deleteSeller(seller: Seller): Int

    suspend fun updateSeller(seller: Seller)

    suspend fun getSellerById(sellerId: Long): Seller

    suspend fun getSellerByContact(contact: String): Seller
}