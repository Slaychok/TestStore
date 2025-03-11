package com.testtask.teststore.di

import android.content.Context
import com.testtask.teststore.data.local.ProductDao
import com.testtask.teststore.data.local.ProductDatabase
import com.testtask.teststore.data.repository.ProductRepositoryImpl
import com.testtask.teststore.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): ProductDatabase {
        return ProductDatabase.getDatabase(context)
    }

    @Provides
    fun provideProductDao(database: ProductDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideProductRepository(dao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(dao)
    }
}
