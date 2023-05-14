package com.example.ecomdemo.ui.viewmodels

import android.database.sqlite.SQLiteConstraintException
import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomdemo.common.SingleLiveEvent
import com.example.ecomdemo.data.db.joins.SellerWithProducts
import com.example.ecomdemo.data.db.relations.CartProduct
import com.example.ecomdemo.data.db.relations.PaymentOrder
import com.example.ecomdemo.data.db.relations.SellerProduct
import com.example.ecomdemo.data.db.entities.*
import com.example.ecomdemo.data.repository.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repositoryCustomer: RepositoryCustomer,
    private val repositoryAddress: RepositoryAddress,
    private val repositorySeller: RepositorySeller,
    private val repositoryCart: RepositoryCart,
    private val repositoryOrder: RepositoryOrder,
    private val repositoryProduct: RepositoryProduct,
    private val repositoryPayment: RepositoryPayment,
    private val repositoryProductImages: RepositoryProductImages,
    private val repositoryCartProduct: RepositoryCartProduct,
    private val repositoryPaymentOrder: RepositoryPaymentOrder,
    private val repositorySellerProduct: RepositorySellerProduct,
) : ViewModel() {

    private val _data = MutableStateFlow("")
    val data = _data

    val cartItems = mutableStateListOf<Product>()
    var count = 1

    var totalPrice = mutableStateOf(0.0)

    var sellerId = 0L

    val _insertCustomer = SingleLiveEvent<Boolean>()
    private val _insertSeller = mutableStateOf(true)

    val _customerListState = MutableLiveData(listOf<Customer>())
    val _sellerListState = MutableLiveData(listOf<Seller>())
    val _productListState = MutableLiveData(listOf<Product>())

    val _customerExists = MutableLiveData<Customer>()
    val _sellerExists = MutableLiveData<Seller>()

    private val _addressListState = MutableStateFlow(listOf<Address>())
    private val _cartListState = MutableStateFlow(listOf<Cart>())
    private val _orderListState = MutableStateFlow(listOf<Order>())

    private val _paymentListState = MutableStateFlow(listOf<Payment>())
    private val _productImagesListState = MutableStateFlow(listOf<ProductImages>())
    private val _cartProductListState = MutableStateFlow(listOf<CartProduct>())
    private val _paymentOrderListState = MutableStateFlow(listOf<PaymentOrder>())

    val sellerProductListState = mutableStateOf<SellerWithProducts?>(null)

    init {
        getAllSellerProduct(sellerId)
    }

    fun insertCustomer(customer: Customer) {
        viewModelScope.launch {
            try {
                val rowCount = repositoryCustomer.insertCustomer(
                    customer
                )
                _insertCustomer.value = rowCount > -1
            } catch (e: SQLiteConstraintException) {
                _insertCustomer.value = false
            }
        }
    }

    fun insertSeller(seller: Seller) {
        viewModelScope.launch {
            try {
                val rowCount = repositorySeller.insertSeller(seller)
                _insertSeller.value = rowCount > -1
            } catch (e: SQLiteConstraintException) {
                _insertSeller.value = false
            }
        }
    }

    fun getAllCustomers() {
        viewModelScope.launch {
            repositoryCustomer.getAllCustomer().collect { customerList ->
                _customerListState.value = customerList
            }
        }
    }

    fun getAllSeller() {
        viewModelScope.launch {
            repositorySeller.getAllSeller().collect { sellerList ->
                _sellerListState.value = sellerList
            }
        }
    }

    fun getAllProducts() {
        viewModelScope.launch {
            repositoryProduct.getAllProduct().collect { productList ->
                _productListState.value = productList
            }
        }
    }

    fun addProduct(name: String, price: Double, categoryName: String, description: String) {
        viewModelScope.launch {
            val id = repositoryProduct.insertProduct(
                Product(
                    name = name,
                    price = price,
                    categoryName = categoryName,
                    description = description
                )
            )
            repositorySellerProduct.insertSellerProduct(
                SellerProduct(
                    productId = id, sellerId = sellerId, offerPrice = 100.00
                )
            )
            getAllSellerProduct(sellerId)
        }
    }

    fun getCustomerByPhoneNumber(phoneNumber: String) {
        viewModelScope.launch {
            _customerExists.value = repositoryCustomer.getCustomerById(phoneNumber)
        }
    }

    fun getSellerByContact(phoneNumber: String) {
        viewModelScope.launch {
            _sellerExists.value = repositorySeller.getSellerByContact(phoneNumber)
            sellerId = _sellerExists.value?.sellerId ?: 1
            getAllSellerProduct(sellerId)
        }
    }

    private fun getAllSellerProduct(sellerId: Long) {
        viewModelScope.launch {
            sellerProductListState.value = repositorySellerProduct.getSellerProductsById(sellerId)
        }
    }

    fun getAllPaymentOrder() {
        viewModelScope.launch {
            repositoryPaymentOrder.getAllPaymentOrder().collect { paymentOrdersList ->
                _paymentOrderListState.value = paymentOrdersList
            }
        }
    }

    fun getAllCartProduct() {
        viewModelScope.launch {
            repositoryCartProduct.getAllCartProduct().collect { cartProductsList ->
                _cartProductListState.value = cartProductsList
            }
        }
    }

    fun getAllProductImages() {
        viewModelScope.launch {
            repositoryProductImages.getAllProductImages().collect { productImagesList ->
                _productImagesListState.value = productImagesList
            }
        }
    }

    fun getAllPayment() {
        viewModelScope.launch {
            repositoryPayment.getAllPayment().collect { paymentList ->
                _paymentListState.value = paymentList
            }
        }
    }

    fun getAllOrder() {
        viewModelScope.launch {
            repositoryOrder.getAllOrder().collect { orderList ->
                _orderListState.value = orderList
            }
        }
    }

    fun getAllAddress() {
        viewModelScope.launch {
            repositoryAddress.getAllAddress().collect { addressList ->
                _addressListState.value = addressList
            }
        }
    }

    fun getAllCart() {
        viewModelScope.launch {
            repositoryCart.getAllCart().collect { cartList ->
                _cartListState.value = cartList
            }
        }
    }
}