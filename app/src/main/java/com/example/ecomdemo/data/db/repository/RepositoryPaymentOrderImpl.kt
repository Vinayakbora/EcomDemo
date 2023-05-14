package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.PaymentOrderDao
import com.example.ecomdemo.data.db.relations.PaymentOrder
import com.example.ecomdemo.data.repository.RepositoryPaymentOrder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryPaymentOrderImpl @Inject constructor(private val paymentOrderDao: PaymentOrderDao) :
    RepositoryPaymentOrder {

    override fun getAllPaymentOrder(): Flow<List<PaymentOrder>> = paymentOrderDao.getAllPaymentOrder()

    override suspend fun insertPaymentOrder(paymentOrder: PaymentOrder): Long =
        paymentOrderDao.insertPaymentOrder(paymentOrder = paymentOrder)

    override suspend fun deletePaymentOrder(paymentOrder: PaymentOrder): Int =
        paymentOrderDao.deletePaymentOrder(paymentOrder = paymentOrder)

    override suspend fun updatePaymentOrder(paymentOrder: PaymentOrder) =
        paymentOrderDao.updatePaymentOrder(paymentOrder = paymentOrder)

    override suspend fun getPaymentOrderById(id: Long) =
        paymentOrderDao.getPaymentOrderById(id = id)
}