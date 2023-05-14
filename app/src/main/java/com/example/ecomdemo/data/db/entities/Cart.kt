package com.example.ecomdemo.data.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableCart

@Entity(
    tableName = TableCart, foreignKeys = [ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("phoneNumber"),
        childColumns = arrayOf("phoneNumber"),
        onUpdate = CASCADE,
        deferred = true
    )]
)
data class Cart(
    @PrimaryKey(autoGenerate = true) val cartId: Long = 0,
    val totalQuantity: Int = 0,
    val phoneNumber: String?,
)
