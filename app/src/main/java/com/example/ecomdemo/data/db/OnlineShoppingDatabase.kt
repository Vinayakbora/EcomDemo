package com.example.ecomdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecomdemo.data.db.dao.*
import com.example.ecomdemo.data.db.entities.*
import com.example.ecomdemo.data.db.relations.CartProduct
import com.example.ecomdemo.data.db.relations.PaymentOrder
import com.example.ecomdemo.data.db.relations.SellerProduct

@Database(
    entities = [
        Customer::class,
        Address::class,
        Seller::class,
        Cart::class,
        Order::class,
        Product::class,
        Payment::class,
        ProductImages::class,
        CartProduct::class,
        PaymentOrder::class,
        SellerProduct::class
    ], version = 1, exportSchema = false
)
abstract class OnlineShoppingDatabase : RoomDatabase() {

    abstract fun getCustomerDao(): CustomerDao
    abstract fun getAddressDao(): AddressDao
    abstract fun getSellerDao(): SellerDao
    abstract fun getCartDao(): CartDao
    abstract fun getOrderDao(): OrderDao
    abstract fun getProductDao(): ProductDao
    abstract fun getPaymentDao(): PaymentDao
    abstract fun getProductImagesDao(): ProductImagesDao
    abstract fun getCartProductDao(): CartProductDao
    abstract fun getPaymentOrderDao(): PaymentOrderDao
    abstract fun getSellerProductDao(): SellerProductDao

    companion object {
        const val DATABASE_NAME = "dbOnlineShopping"
    }
}