package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableCart
import com.example.ecomdemo.data.db.entities.Cart
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart: Cart): Long

    @Update
    suspend fun updateCart(cart: Cart)

    @Delete
    suspend fun deleteCart(cart: Cart): Int

    @Query("SELECT * FROM $TableCart")
    fun getAllCart(): Flow<List<Cart>>

    @Query("SELECT * FROM $TableCart WHERE cartId=:cartId")
    suspend fun getCartById(cartId: Long): Cart
}