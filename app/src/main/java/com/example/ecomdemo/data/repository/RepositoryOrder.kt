package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.Order
import kotlinx.coroutines.flow.Flow

interface RepositoryOrder {

    fun getAllOrder(): Flow<List<Order>>

    suspend fun insertOrder(order: Order): Long

    suspend fun deleteOrder(order: Order): Int

    suspend fun updateOrder(order: Order)

    suspend fun getOrderById(orderId: Long): Order
}