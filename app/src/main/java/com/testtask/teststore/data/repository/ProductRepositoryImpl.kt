package com.testtask.teststore.data.repository

import com.testtask.teststore.data.local.ProductDao
import com.testtask.teststore.data.mappers.toEntity
import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.testtask.teststore.data.mappers.toDomain

class ProductRepositoryImpl(private val dao: ProductDao) : ProductRepository {
    override fun getAllProducts(): Flow<List<Product>> {
        return dao.getAllProducts().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun insertProduct(product: Product) {
        dao.insertProducts(listOf(product.toEntity()))
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
