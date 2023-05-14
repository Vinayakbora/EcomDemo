package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableCustomer
import com.example.ecomdemo.data.db.entities.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertCustomer(customer: Customer): Long

    @Update
    suspend fun updateCustomer(customer: Customer)

    @Delete
    suspend fun deleteCustomer(customer: Customer): Int

    @Query("SELECT * FROM $TableCustomer")
    fun getAllCustomer(): Flow<List<Customer>>

    @Query("SELECT * FROM $TableCustomer WHERE phoneNumber=:phoneNumber")
    suspend fun getCustomerById(phoneNumber: String): Customer
}