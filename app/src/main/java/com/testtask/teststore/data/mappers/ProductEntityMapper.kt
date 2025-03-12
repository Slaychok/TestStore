package com.testtask.teststore.data.mappers

import com.testtask.teststore.data.local.ProductDbo
import com.testtask.teststore.domain.model.Product

fun ProductDbo.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.name,
        time = this.time,
        tags = this.tags,
        amount = this.amount
    )
}

fun Product.toEntity(): ProductDbo {
    return ProductDbo(
        id = this.id,
        name = this.name,
        time = this.time,
        tags = this.tags,
        amount = this.amount
    )
}
