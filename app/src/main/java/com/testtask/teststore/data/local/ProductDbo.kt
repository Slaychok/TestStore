package com.testtask.teststore.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "products")
@TypeConverters(Converters::class)
data class ProductDbo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)
