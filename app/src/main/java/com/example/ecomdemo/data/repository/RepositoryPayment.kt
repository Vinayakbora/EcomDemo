package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.Payment
import kotlinx.coroutines.flow.Flow

interface RepositoryPayment {

    fun getAllPayment(): Flow<List<Payment>>

    suspend fun insertPayment(payment: Payment): Long

    suspend fun deletePayment(payment: Payment): Int

    suspend fun updatePayment(payment: Payment)

    suspend fun getPaymentById(paymentId: Long): Payment
}