package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.ProductDao
import com.example.ecomdemo.data.db.entities.Product
import com.example.ecomdemo.data.repository.RepositoryProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryProductImpl @Inject constructor(private val productDao: ProductDao) :
    RepositoryProduct {

    override fun getAllProduct(): Flow<List<Product>> {
        return productDao.getAllProduct()
    }

    override suspend fun insertProduct(product: Product): Long =
        productDao.insertProduct(product = product)

    override suspend fun deleteProduct(product: Product): Int =
        productDao.deleteProduct(product = product)

    override suspend fun updateProduct(product: Product) =
        productDao.updateProduct(product = product)

    override suspend fun getProductById(productId: Long) = productDao.getProductById(productId = productId)
}