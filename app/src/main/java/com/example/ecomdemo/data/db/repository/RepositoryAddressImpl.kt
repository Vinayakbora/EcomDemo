package com.example.ecomdemo.data.db.repository

import com.example.ecomdemo.data.db.dao.AddressDao
import com.example.ecomdemo.data.db.entities.Address
import com.example.ecomdemo.data.repository.RepositoryAddress
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryAddressImpl @Inject constructor(private val addressDao: AddressDao) :
    RepositoryAddress {

    override fun getAllAddress(): Flow<List<Address>> = addressDao.getAllAddress()

    override suspend fun insertAddress(address: Address): Long =
        addressDao.insertAddress(address = address)

    override suspend fun deleteAddress(address: Address): Int =
        addressDao.deleteAddress(address = address)

    override suspend fun updateAddress(address: Address) =
        addressDao.updateAddress(address = address)

    override suspend fun getAddressById(phoneNumber: String) = addressDao.getAddressById(phoneNumber = phoneNumber)
}