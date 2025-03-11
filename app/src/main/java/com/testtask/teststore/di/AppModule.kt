package com.testtask.teststore.di

import android.content.Context
import com.testtask.teststore.data.local.ProductDao
import com.testtask.teststore.data.local.ProductDatabase
import com.testtask.teststore.data.repository.ProductRepositoryImpl
import com.testtask.teststore.domain.repository.ProductRepository
import com.testtask.teststore.domain.usecase.AddProductUseCase
import com.testtask.teststore.domain.usecase.DeleteProductUseCase
import com.testtask.teststore.domain.usecase.GetProductsUseCase
import com.testtask.teststore.domain.usecase.SearchProductsUseCase
import com.testtask.teststore.domain.usecase.UpdateProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ProductDatabase {
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

    @Provides
    fun provideGetProductsUseCase(repository: ProductRepository): GetProductsUseCase {
        return GetProductsUseCase(repository)
    }

    @Provides
    fun provideAddProductUseCase(repository: ProductRepository): AddProductUseCase {
        return AddProductUseCase(repository)
    }

    @Provides
    fun provideDeleteProductUseCase(repository: ProductRepository): DeleteProductUseCase {
        return DeleteProductUseCase(repository)
    }

    @Provides
    fun provideUpdateProductUseCase(repository: ProductRepository): UpdateProductUseCase {
        return UpdateProductUseCase(repository)
    }

    @Provides
    fun provideSearchProductsUseCase(repository: ProductRepository): SearchProductsUseCase {
        return SearchProductsUseCase(repository)
    }
}

