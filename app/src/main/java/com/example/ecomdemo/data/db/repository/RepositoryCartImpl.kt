package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.CartDao
import com.example.ecomdemo.data.db.entities.Cart
import com.example.ecomdemo.data.repository.RepositoryCart
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryCartImpl @Inject constructor(private val cartDao: CartDao) :
    RepositoryCart {

    override fun getAllCart(): Flow<List<Cart>> = cartDao.getAllCart()

    override suspend fun insertCart(cart: Cart): Long =
        cartDao.insertCart(cart = cart)

    override suspend fun deleteCart(cart: Cart): Int =
        cartDao.deleteCart(cart = cart)

    override suspend fun updateCart(cart: Cart) =
        cartDao.updateCart(cart = cart)

    override suspend fun getCartById(cartId: Long) = cartDao.getCartById(cartId = cartId)
}