package com.example.ecomdemo.application.di

import android.content.Context
import androidx.room.Room
import com.example.ecomdemo.data.db.OnlineShoppingDatabase
import com.example.ecomdemo.data.db.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideOnlineShoppingDatabase(@ApplicationContext context: Context): OnlineShoppingDatabase {
        return Room.databaseBuilder(
            context,
            OnlineShoppingDatabase::class.java,
            OnlineShoppingDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideCustomerDao(database: OnlineShoppingDatabase): CustomerDao =
        database.getCustomerDao()

    @Singleton
    @Provides
    fun provideAddressDao(database: OnlineShoppingDatabase): AddressDao = database.getAddressDao()

    @Singleton
    @Provides
    fun provideSellerDao(database: OnlineShoppingDatabase): SellerDao = database.getSellerDao()

    @Singleton
    @Provides
    fun provideCartDao(database: OnlineShoppingDatabase): CartDao = database.getCartDao()

    @Singleton
    @Provides
    fun provideOrderDao(database: OnlineShoppingDatabase): OrderDao = database.getOrderDao()

    @Singleton
    @Provides
    fun provideProductDao(database: OnlineShoppingDatabase): ProductDao = database.getProductDao()

    @Singleton
    @Provides
    fun providePaymentDao(database: OnlineShoppingDatabase): PaymentDao = database.getPaymentDao()

    @Singleton
    @Provides
    fun provideProductImagesDao(database: OnlineShoppingDatabase): ProductImagesDao =
        database.getProductImagesDao()

    @Singleton
    @Provides
    fun provideCartProductDao(database: OnlineShoppingDatabase): CartProductDao =
        database.getCartProductDao()

    @Singleton
    @Provides
    fun provideSellerProductDao(database: OnlineShoppingDatabase): SellerProductDao =
        database.getSellerProductDao()

    @Singleton
    @Provides
    fun providePaymentOrderDao(database: OnlineShoppingDatabase): PaymentOrderDao =
        database.getPaymentOrderDao()

}