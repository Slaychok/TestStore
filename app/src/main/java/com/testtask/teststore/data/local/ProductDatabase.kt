package com.testtask.teststore.data.local

import android.content.Context
import androidx.room.*

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile private var instance: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build().also { instance = it }
            }
        }
    }
}
