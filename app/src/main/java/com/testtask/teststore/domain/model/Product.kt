package com.testtask.teststore.domain.model

data class Product(
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)
