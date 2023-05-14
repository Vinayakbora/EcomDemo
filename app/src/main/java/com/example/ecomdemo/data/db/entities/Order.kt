package com.example.ecomdemo.data.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableOrder

@Entity(
    tableName = TableOrder,
    foreignKeys = [ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("phoneNumber"),
        childColumns = arrayOf("phoneNumber"),
        onUpdate = ForeignKey.CASCADE,
        deferred = true
    )]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Long = 0,
    val orderStatus: String? = null,
    val phoneNumber: String? = null,
    val orderDate: String? = null,
    val totalCost: Double = 0.0,
)
