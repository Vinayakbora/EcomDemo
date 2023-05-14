package com.example.ecomdemo.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableSeller

@Entity(tableName = TableSeller)
data class Seller(
    @PrimaryKey(autoGenerate = true)
    val sellerId: Long = 0,
    val name: String? = null,
    val contact: String? = null,
    val address: String? = null,
)
