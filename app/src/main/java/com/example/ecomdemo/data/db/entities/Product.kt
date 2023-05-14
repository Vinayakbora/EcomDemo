package com.example.ecomdemo.data.db.entities

import androidx.compose.runtime.mutableStateOf
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.ecomdemo.data.db.DatabaseConstants.TableProduct

@Entity(tableName = TableProduct)
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Long = 0,
    val name: String? = null,
    val price: Double = 0.0,
    val categoryName: String? = null,
    val description: String? = null,
    var quantity: Int = 0,
) {
    @Ignore
    val mutableQuantity = mutableStateOf(quantity)

    @Ignore
    fun increaseQuantity() {
        mutableQuantity.value = ++this.quantity
    }

    @Ignore
    fun decreaseQuantity() {
        mutableQuantity.value = --this.quantity
    }

    @Ignore
    fun updateQuantity(quantity: Int) {
        this.quantity = quantity
        mutableQuantity.value = quantity
    }
}
