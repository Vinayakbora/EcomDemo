package com.example.ecomdemo.data.repository

import com.example.ecomdemo.data.db.entities.Address
import kotlinx.coroutines.flow.Flow

interface RepositoryAddress {

    fun getAllAddress(): Flow<List<Address>>

    suspend fun insertAddress(address: Address): Long

    suspend fun deleteAddress(address: Address): Int

    suspend fun updateAddress(address: Address)

    suspend fun getAddressById(phoneNumber: String): Address
}