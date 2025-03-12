package com.testtask.teststore.domain.usecase

import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(private val repository: ProductRepository) {
    operator fun invoke(query: String): Flow<List<Product>> {
        return repository.searchProducts(query)
    }
}