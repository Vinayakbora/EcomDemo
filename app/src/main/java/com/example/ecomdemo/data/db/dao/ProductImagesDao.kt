package com.example.ecomdemo.data.db.dao

import androidx.room.*
import com.example.ecomdemo.data.db.DatabaseConstants.TableProductImages
import com.example.ecomdemo.data.db.entities.ProductImages
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductImagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductImages(productImages: ProductImages): Long

    @Update
    suspend fun updateProductImages(productImages: ProductImages)

    @Delete
    suspend fun deleteProductImages(productImages: ProductImages): Int

    @Query("SELECT * FROM $TableProductImages")
    fun getAllProductImages(): Flow<List<ProductImages>>

    @Query("SELECT * FROM $TableProductImages WHERE id=:id")
    suspend fun getProductImagesById(id: Long): ProductImages
}