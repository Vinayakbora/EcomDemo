package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.relations.PaymentOrder
import kotlinx.coroutines.flow.Flow

interface RepositoryPaymentOrder {

    fun getAllPaymentOrder(): Flow<List<PaymentOrder>>

    suspend fun insertPaymentOrder(paymentOrder: PaymentOrder): Long

    suspend fun deletePaymentOrder(paymentOrder: PaymentOrder): Int

    suspend fun updatePaymentOrder(paymentOrder: PaymentOrder)

    suspend fun getPaymentOrderById(id: Long): PaymentOrder
}