package com.example.ecomdemo.data.db.relations

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableCartProduct
import com.example.ecomdemo.data.db.entities.Cart
import com.example.ecomdemo.data.db.entities.Product

@Entity(
    tableName = TableCartProduct,
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("productId"),
            childColumns = arrayOf("productId"),
            onDelete = CASCADE,
            onUpdate = CASCADE,
            deferred = true
        ),
        ForeignKey(
            entity = Cart::class,
            parentColumns = arrayOf("cartId"),
            childColumns = arrayOf("cartId"),
            onDelete = CASCADE,
            onUpdate = CASCADE,
            deferred = true
        )
    ]
)
data class CartProduct(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val cartId: Long,
    val productId: Long,
)
