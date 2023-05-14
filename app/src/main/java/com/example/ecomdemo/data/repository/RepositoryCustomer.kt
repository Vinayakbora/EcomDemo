package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.Customer
import kotlinx.coroutines.flow.Flow

interface RepositoryCustomer {

    fun getAllCustomer(): Flow<List<Customer>>

    suspend fun insertCustomer(customer: Customer): Long

    suspend fun deleteCustomer(customer: Customer): Int

    suspend fun updateCustomer(customer: Customer)

    suspend fun getCustomerById(phoneNumber: String): Customer
}