package com.example.ecomdemo.data.db.joins

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.ecomdemo.data.db.entities.Product
import com.example.ecomdemo.data.db.entities.Seller
import com.example.ecomdemo.data.db.relations.SellerProduct

data class SellerWithProducts(
    @Embedded val seller: Seller,
    @Relation(
        parentColumn = "sellerId",
        entity = Product::class,
        entityColumn = "productId",
        associateBy = Junction(SellerProduct::class)
    ) val product: List<Product>,
)