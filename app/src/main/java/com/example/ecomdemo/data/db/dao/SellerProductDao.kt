package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableSeller
import com.example.ecomdemo.data.db.DatabaseConstants.TableSellerProduct
import com.example.ecomdemo.data.db.joins.SellerWithProducts
import com.example.ecomdemo.data.db.relations.SellerProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface SellerProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSellerProduct(sellerProduct: SellerProduct): Long

    @Update
    suspend fun updateSellerProduct(sellerProduct: SellerProduct)

    @Delete
    suspend fun deleteSellerProduct(sellerProduct: SellerProduct): Int

    @Query("SELECT * FROM $TableSellerProduct")
    fun getAllSellerProduct(): Flow<List<SellerProduct>>

    @Query("SELECT * FROM $TableSellerProduct WHERE id=:id")
    suspend fun getSellerProductById(id: Long): SellerProduct

    @Query("SELECT * FROM $TableSeller WHERE sellerId=:sellerId")
    suspend fun getSellerProductsById(sellerId: Long): SellerWithProducts

}