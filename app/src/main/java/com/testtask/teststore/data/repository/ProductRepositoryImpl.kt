package com.testtask.teststore.data.repository

import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl(private val dao: ProductDao) : ProductRepository {
    override fun getAllProducts(): Flow<List<Product>> {
        return dao.getAllProducts().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun insertProduct(product: Product) {
        dao.insertProduct(product.toEntity())
    }

    override suspend fun updateProduct(product: Product) {
        dao.updateProduct(product.toEntity())
    }

    override suspend fun deleteProduct(product: Product) {
        dao.deleteProduct(product.toEntity())
    }

    override fun searchProducts(query: String): Flow<List<Product>> {
        return dao.searchProducts(query).map { list -> list.map { it.toDomain() } }
    }
}
