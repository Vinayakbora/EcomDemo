package com.example.ecomdemo.data.db.relations

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableOrderProduct

@Entity(
    tableName = TableOrderProduct,
)
data class OrderProduct(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val orderId: Long,
    val productId: Long,
    val quantity: Int = 0,
)
