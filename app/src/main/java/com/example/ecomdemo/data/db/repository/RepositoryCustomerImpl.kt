package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.CustomerDao
import com.example.ecomdemo.data.db.entities.Customer
import com.example.ecomdemo.data.repository.RepositoryCustomer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryCustomerImpl @Inject constructor(private val customerDao: CustomerDao) :
    RepositoryCustomer {

    override fun getAllCustomer(): Flow<List<Customer>> = customerDao.getAllCustomer()

    override suspend fun insertCustomer(customer: Customer): Long =
        customerDao.insertCustomer(customer = customer)

    override suspend fun deleteCustomer(customer: Customer): Int =
        customerDao.deleteCustomer(customer = customer)

    override suspend fun updateCustomer(customer: Customer) =
        customerDao.updateCustomer(customer = customer)

    override suspend fun getCustomerById(phoneNumber: String) = customerDao.getCustomerById(phoneNumber = phoneNumber)
}