package com.testtask.teststore.domain.usecase

import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.repository.ProductRepository

class AddProductUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(product: Product) {
        repository.insertProduct(product)
    }
}
