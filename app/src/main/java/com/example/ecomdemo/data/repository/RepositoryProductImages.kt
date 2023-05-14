package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.ProductImages
import kotlinx.coroutines.flow.Flow

interface RepositoryProductImages {

    fun getAllProductImages(): Flow<List<ProductImages>>

    suspend fun insertProductImages(productImages: ProductImages): Long

    suspend fun deleteProductImages(productImages: ProductImages): Int

    suspend fun updateProductImages(productImages: ProductImages)

    suspend fun getProductImagesById(id: Long): ProductImages
}