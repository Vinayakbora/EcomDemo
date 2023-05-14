package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableAddress
import com.example.ecomdemo.data.db.entities.Address
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(address: Address): Long

    @Update
    suspend fun updateAddress(address: Address)

    @Delete
    suspend fun deleteAddress(address: Address): Int

    @Query("SELECT * FROM $TableAddress")
    fun getAllAddress(): Flow<List<Address>>

    @Query("SELECT * FROM $TableAddress WHERE phoneNumber=:phoneNumber")
    suspend fun getAddressById(phoneNumber: String): Address
}