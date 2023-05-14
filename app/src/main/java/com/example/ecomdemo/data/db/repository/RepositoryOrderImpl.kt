package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.OrderDao
import com.example.ecomdemo.data.db.entities.Order
import com.example.ecomdemo.data.repository.RepositoryOrder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryOrderImpl @Inject constructor(private val orderDao: OrderDao) :
    RepositoryOrder {

    override fun getAllOrder(): Flow<List<Order>> = orderDao.getAllOrder()

    override suspend fun insertOrder(order: Order): Long =
        orderDao.insertOrder(order = order)

    override suspend fun deleteOrder(order: Order): Int =
        orderDao.deleteOrder(order = order)

    override suspend fun updateOrder(order: Order) =
        orderDao.updateOrder(order = order)

    override suspend fun getOrderById(orderId: Long) = orderDao.getOrderById(orderId = orderId)
}