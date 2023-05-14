package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TablePaymentOrder
import com.example.ecomdemo.data.db.relations.PaymentOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentOrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaymentOrder(paymentOrder: PaymentOrder): Long

    @Update
    suspend fun updatePaymentOrder(paymentOrder: PaymentOrder)

    @Delete
    suspend fun deletePaymentOrder(paymentOrder: PaymentOrder): Int

    @Query("SELECT * FROM $TablePaymentOrder")
    fun getAllPaymentOrder(): Flow<List<PaymentOrder>>

    @Query("SELECT * FROM $TablePaymentOrder WHERE id=:id")
    suspend fun getPaymentOrderById(id: Long): PaymentOrder
}