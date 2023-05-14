package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableProduct
import com.example.ecomdemo.data.db.entities.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product): Long

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product): Int

    @Query("SELECT * FROM $TableProduct")
    fun getAllProduct(): Flow<List<Product>>

    @Query("SELECT * FROM $TableProduct WHERE productId=:productId")
    suspend fun getProductById(productId: Long): Product
}