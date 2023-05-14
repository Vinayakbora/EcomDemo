package com.example.ecomdemo.data.db.relations

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TablePaymentOrder

@Entity(tableName = TablePaymentOrder)
data class PaymentOrder(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val paymentId: Long = 0,
    val orderId: Long = 0
)