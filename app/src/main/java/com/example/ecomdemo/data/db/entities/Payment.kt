package com.example.ecomdemo.data.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TablePayment

@Entity(
    tableName = TablePayment,
    foreignKeys = [ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("phoneNumber"),
        childColumns = arrayOf("phoneNumber"),
        onUpdate = CASCADE,
        deferred = true
    )]
)
data class Payment(
    @PrimaryKey(autoGenerate = true)
    val paymentId: Long = 0,
    val paymentDate: String? = null,
    val amount: Double = 0.0,
    val phoneNumber: String? = null,
)
