package com.example.ecomdemo.data.db.relations

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableSellerProduct

@Entity(tableName = TableSellerProduct)
data class SellerProduct(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val productId: Long = 0,
    val sellerId: Long = 0,
    val offerPrice: Double = 0.0,
)