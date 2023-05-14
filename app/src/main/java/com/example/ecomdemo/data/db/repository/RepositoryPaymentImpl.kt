package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.PaymentDao
import com.example.ecomdemo.data.db.entities.Payment
import com.example.ecomdemo.data.repository.RepositoryPayment
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryPaymentImpl @Inject constructor(private val paymentDao: PaymentDao) :
    RepositoryPayment {

    override fun getAllPayment(): Flow<List<Payment>> = paymentDao.getAllPayment()

    override suspend fun insertPayment(payment: Payment): Long =
        paymentDao.insertPayment(payment = payment)

    override suspend fun deletePayment(payment: Payment): Int =
        paymentDao.deletePayment(payment = payment)

    override suspend fun updatePayment(payment: Payment) =
        paymentDao.updatePayment(payment = payment)

    override suspend fun getPaymentById(paymentId: Long) =
        paymentDao.getPaymentById(paymentId = paymentId)
}