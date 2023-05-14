package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.joins.SellerWithProducts
import com.example.ecomdemo.data.db.relations.SellerProduct
import kotlinx.coroutines.flow.Flow

interface RepositorySellerProduct {

    fun getAllSellerProduct(): Flow<List<SellerProduct>>

    suspend fun insertSellerProduct(sellerProduct: SellerProduct): Long

    suspend fun deleteSellerProduct(sellerProduct: SellerProduct): Int

    suspend fun updateSellerProduct(sellerProduct: SellerProduct)

    suspend fun getSellerProductById(id: Long): SellerProduct

    suspend fun getSellerProductsById(sellerId: Long): SellerWithProducts

}