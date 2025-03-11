package com.testtask.teststore.domain.usecase

import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: ProductRepository) {
    operator fun invoke(): Flow<List<Product>> {
        return repository.getAllProducts()
    }
}