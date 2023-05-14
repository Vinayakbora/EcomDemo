package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.CartProductDao
import com.example.ecomdemo.data.db.relations.CartProduct
import com.example.ecomdemo.data.repository.RepositoryCartProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryCartProductImpl @Inject constructor(private val cartProductDao: CartProductDao) :
    RepositoryCartProduct {

    override fun getAllCartProduct(): Flow<List<CartProduct>> = cartProductDao.getAllCartProduct()

    override suspend fun insertCartProduct(cartProduct: CartProduct): Long =
        cartProductDao.insertCartProduct(cartProduct = cartProduct)

    override suspend fun deleteCartProduct(cartProduct: CartProduct): Int =
        cartProductDao.deleteCartProduct(cartProduct = cartProduct)

    override suspend fun updateCartProduct(cartProduct: CartProduct) =
        cartProductDao.updateCartProduct(cartProduct = cartProduct)

    override suspend fun getCartProductById(id: Long) =
        cartProductDao.getCartProductById(id = id)
}