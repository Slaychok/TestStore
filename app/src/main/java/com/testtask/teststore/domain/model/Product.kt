package com.testtask.teststore.domain.model

data class Product(
    val id: Int = 0,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val tags: List<String>
)
