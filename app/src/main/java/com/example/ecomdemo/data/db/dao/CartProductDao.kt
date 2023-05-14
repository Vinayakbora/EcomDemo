package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableCartProduct
import com.example.ecomdemo.data.db.relations.CartProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface CartProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartProduct(cartProduct: CartProduct): Long

    @Update
    suspend fun updateCartProduct(cartProduct: CartProduct)

    @Delete
    suspend fun deleteCartProduct(cartProduct: CartProduct): Int

    @Query("SELECT * FROM $TableCartProduct")
    fun getAllCartProduct(): Flow<List<CartProduct>>

    @Query("SELECT * FROM $TableCartProduct WHERE id=:id")
    suspend fun getCartProductById(id: Long): CartProduct
}