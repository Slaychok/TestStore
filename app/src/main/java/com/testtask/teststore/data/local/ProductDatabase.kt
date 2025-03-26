package com.testtask.teststore.data.local

import android.content.Context
import androidx.room.*

@Database(entities = [ProductDbo::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var instance: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return instance ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                )
                    .createFromAsset("product_database.db")
                    .fallbackToDestructiveMigration()
                    .build()
                instance = db
                db
            }
        }
    }
}