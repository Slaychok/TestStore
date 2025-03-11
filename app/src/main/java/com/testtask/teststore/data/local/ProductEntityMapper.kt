package com.testtask.teststore.data.local

import com.testtask.teststore.domain.model.Product

fun ProductEntity.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        quantity = this.quantity,
        tags = this.tags
    )
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        quantity = this.quantity,
        tags = this.tags
    )
}