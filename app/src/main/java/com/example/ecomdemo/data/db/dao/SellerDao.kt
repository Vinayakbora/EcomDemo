package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableSeller
import com.example.ecomdemo.data.db.entities.Seller
import kotlinx.coroutines.flow.Flow

@Dao
interface SellerDao {

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertSeller(seller: Seller): Long

    @Update
    suspend fun updateSeller(seller: Seller)

    @Delete
    suspend fun deleteSeller(seller: Seller): Int

    @Query("SELECT * FROM $TableSeller")
    fun getAllSeller(): Flow<List<Seller>>

    @Query("SELECT * FROM $TableSeller WHERE sellerId=:sellerId")
    suspend fun getSellerById(sellerId: Long): Seller

    @Query("SELECT * FROM $TableSeller WHERE contact=:contact")
    suspend fun getSellerByContact(contact: String): Seller
}