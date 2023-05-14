package com.example.ecomdemo.data.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableProductImages

@Entity(
    tableName = TableProductImages, foreignKeys = [ForeignKey(
        entity = Product::class,
        parentColumns = ["productId"],
        childColumns = ["productId"],
        onDelete = CASCADE
    )]
)
data class ProductImages(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val productId: Long = 0,
    val image: String? = null,
)
