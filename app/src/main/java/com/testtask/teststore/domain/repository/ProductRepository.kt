package com.testtask.teststore.domain.repository

import com.testtask.teststore.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts(): Flow<List<Product>>
    suspend fun insertProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(product: Product)
    fun searchProducts(query: String): Flow<List<Product>>
}