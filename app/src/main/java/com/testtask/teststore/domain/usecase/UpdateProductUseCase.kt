package com.testtask.teststore.domain.usecase

import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.repository.ProductRepository

class UpdateProductUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(product: Product) {
        repository.updateProduct(product)
    }
}