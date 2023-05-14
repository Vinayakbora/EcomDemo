package com.example.ecomdemo.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableCustomer

@Entity(tableName = TableCustomer)
data class Customer(
    @PrimaryKey val phoneNumber: String,
    val emailId: String,
    val password: String,
    val firstName: String,
    val lastName: String,
)
