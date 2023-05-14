package com.example.ecomdemo.data.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableAddress

@Entity(
    tableName = TableAddress,
    foreignKeys = [ForeignKey(
        entity = Customer::class,
        parentColumns = arrayOf("phoneNumber"),
        childColumns = arrayOf("phoneNumber"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Address(
    @PrimaryKey val phoneNumber: String = "",
    val apartmentNo: String? = null,
    val streetAddress: String? = null,
    val city: String? = null,
    val state: String? = null,
    val zipCode: String? = null,
)
