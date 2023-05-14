package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableOrder
import com.example.ecomdemo.data.db.entities.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order): Long

    @Update
    suspend fun updateOrder(order: Order)

    @Delete
    suspend fun deleteOrder(order: Order): Int

    @Query("SELECT * FROM $TableOrder")
    fun getAllOrder(): Flow<List<Order>>

    @Query("SELECT * FROM $TableOrder WHERE orderId=:orderId")
    suspend fun getOrderById(orderId: Long): Order
}