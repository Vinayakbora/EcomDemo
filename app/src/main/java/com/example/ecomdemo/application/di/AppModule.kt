package com.example.ecomdemo.application.di

import com.example.ecomdemo.data.db.dao.*
import com.example.ecomdemo.data.db.repository.*
import com.example.ecomdemo.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCustomerRepository(customerDao: CustomerDao): RepositoryCustomer =
        RepositoryCustomerImpl(customerDao = customerDao)


    @Provides
    @Singleton
    fun provideAddressRepository(addressDao: AddressDao): RepositoryAddress =
        RepositoryAddressImpl(addressDao = addressDao)

    @Provides
    @Singleton
    fun provideSellerRepository(sellerDao: SellerDao): RepositorySeller =
        RepositorySellerImpl(sellerDao = sellerDao)

    @Provides
    @Singleton
    fun provideCartRepository(cartDao: CartDao): RepositoryCart =
        RepositoryCartImpl(cartDao = cartDao)

    @Provides
    @Singleton
    fun provideOrderRepository(orderDao: OrderDao): RepositoryOrder =
        RepositoryOrderImpl(orderDao = orderDao)

    @Provides
    @Singleton
    fun provideProductRepository(productDao: ProductDao): RepositoryProduct =
        RepositoryProductImpl(productDao = productDao)

    @Provides
    @Singleton
    fun providePaymentRepository(paymentDao: PaymentDao): RepositoryPayment =
        RepositoryPaymentImpl(paymentDao = paymentDao)

    @Provides
    @Singleton
    fun provideProductImagesRepository(productImagesDao: ProductImagesDao): RepositoryProductImages =
        RepositoryProductImagesImpl(productImagesDao = productImagesDao)

    @Provides
    @Singleton
    fun provideCartProductRepository(cartProductDao: CartProductDao): RepositoryCartProduct =
        RepositoryCartProductImpl(cartProductDao = cartProductDao)

    @Provides
    @Singleton
    fun providePaymentOrderRepository(paymentOrderDao: PaymentOrderDao): RepositoryPaymentOrder =
        RepositoryPaymentOrderImpl(paymentOrderDao = paymentOrderDao)

    @Provides
    @Singleton
    fun provideSellerProductRepository(sellerProductDao: SellerProductDao): RepositorySellerProduct =
        RepositorySellerProductImpl(sellerProductDao = sellerProductDao)

}