package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.SellerDao
import com.example.ecomdemo.data.db.entities.Seller
import com.example.ecomdemo.data.repository.RepositorySeller
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositorySellerImpl @Inject constructor(private val sellerDao: SellerDao): RepositorySeller {

    override fun getAllSeller(): Flow<List<Seller>> = sellerDao.getAllSeller()

    override suspend fun insertSeller(seller: Seller): Long =
        sellerDao.insertSeller(seller = seller)

    override suspend fun deleteSeller(seller: Seller): Int = sellerDao.deleteSeller(seller = seller)

    override suspend fun updateSeller(seller: Seller) = sellerDao.updateSeller(seller = seller)

    override suspend fun getSellerById(sellerId: Long) =
        sellerDao.getSellerById(sellerId = sellerId)

    override suspend fun getSellerByContact(contact: String) =
        sellerDao.getSellerByContact(contact = contact)
}