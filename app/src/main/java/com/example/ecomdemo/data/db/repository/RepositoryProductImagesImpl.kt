package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.ProductImagesDao
import com.example.ecomdemo.data.db.entities.ProductImages
import com.example.ecomdemo.data.repository.RepositoryProductImages
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryProductImagesImpl @Inject constructor(private val productImagesDao: ProductImagesDao) :
    RepositoryProductImages {

    override fun getAllProductImages(): Flow<List<ProductImages>> = productImagesDao.getAllProductImages()

    override suspend fun insertProductImages(productImages: ProductImages): Long =
        productImagesDao.insertProductImages(productImages = productImages)

    override suspend fun deleteProductImages(productImages: ProductImages): Int =
        productImagesDao.deleteProductImages(productImages = productImages)

    override suspend fun updateProductImages(productImages: ProductImages) =
        productImagesDao.updateProductImages(productImages = productImages)

    override suspend fun getProductImagesById(id: Long) = productImagesDao.getProductImagesById(id = id)
}