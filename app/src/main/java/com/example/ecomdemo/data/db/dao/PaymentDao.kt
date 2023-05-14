package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TablePayment
import com.example.ecomdemo.data.db.entities.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPayment(payment: Payment): Long

    @Update
    suspend fun updatePayment(payment: Payment)

    @Delete
    suspend fun deletePayment(payment: Payment): Int

    @Query("SELECT * FROM $TablePayment")
    fun getAllPayment(): Flow<List<Payment>>

    @Query("SELECT * FROM $TablePayment WHERE paymentId=:paymentId")
    suspend fun getPaymentById(paymentId: Long): Payment
}