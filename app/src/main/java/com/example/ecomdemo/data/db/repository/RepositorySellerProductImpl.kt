package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.SellerProductDao
import com.example.ecomdemo.data.db.relations.SellerProduct
import com.example.ecomdemo.data.repository.RepositorySellerProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositorySellerProductImpl @Inject constructor(private val sellerProductDao: SellerProductDao) :
    RepositorySellerProduct {

    override fun getAllSellerProduct(): Flow<List<SellerProduct>> =
        sellerProductDao.getAllSellerProduct()

    override suspend fun insertSellerProduct(sellerProduct: SellerProduct): Long =
        sellerProductDao.insertSellerProduct(sellerProduct = sellerProduct)

    override suspend fun deleteSellerProduct(sellerProduct: SellerProduct): Int =
        sellerProductDao.deleteSellerProduct(sellerProduct = sellerProduct)

    override suspend fun updateSellerProduct(sellerProduct: SellerProduct) =
        sellerProductDao.updateSellerProduct(sellerProduct = sellerProduct)

    override suspend fun getSellerProductById(id: Long) =
        sellerProductDao.getSellerProductById(id = id)

    override suspend fun getSellerProductsById(sellerId: Long) =
        sellerProductDao.getSellerProductsById(sellerId = sellerId)
}