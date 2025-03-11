package com.testtask.teststore.data.mappers

import com.testtask.teststore.data.local.ProductEntity
import com.testtask.teststore.domain.model.Product

fun ProductEntity.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.name,
        time = this.time,
        tags = this.tags,
        amount = this.amount
    )
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        name = this.name,
        time = this.time,
        tags = this.tags,
        amount = this.amount
    )
}
