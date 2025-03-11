package com.testtask.teststore.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val searchProductsUseCase: SearchProductsUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            getProductsUseCase()
                .collect { _products.value = it }
        }
    }

    fun searchProducts(query: String) {
        _searchQuery.value = query
        viewModelScope.launch {
            searchProductsUseCase(query)
                .collect { _products.value = it }
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            deleteProductUseCase(product)
            loadProducts()
        }
    }

    fun updateProduct(product: Product) {
        viewModelScope.launch {
            updateProductUseCase(product)
            loadProducts()
        }
    }
}
