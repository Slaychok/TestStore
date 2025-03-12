package com.testtask.teststore

import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.domain.usecase.DeleteProductUseCase
import com.testtask.teststore.domain.usecase.GetProductsUseCase
import com.testtask.teststore.domain.usecase.SearchProductsUseCase
import com.testtask.teststore.domain.usecase.UpdateProductUseCase
import com.testtask.teststore.presentation.viewmodels.ProductViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProductViewModelTest {

    private lateinit var viewModel: ProductViewModel
    private val getProductsUseCase: GetProductsUseCase = mockk()
    private val deleteProductUseCase: DeleteProductUseCase = mockk(relaxed = true)
    private val updateProductUseCase: UpdateProductUseCase = mockk()
    private val searchProductsUseCase: SearchProductsUseCase = mockk()

    private val testDispatcher = StandardTestDispatcher()

    private val testProducts = listOf(
        Product(id = 1, name = "iPhone 13", time = 1633046400000, tags = listOf("Телефон"), amount = 15),
        Product(id = 2, name = "Samsung Galaxy S21", time = 1633132800000, tags = listOf("Телефон"), amount = 30)
    )

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        coEvery { getProductsUseCase() } returns flowOf(testProducts)

        viewModel = ProductViewModel(
            getProductsUseCase = getProductsUseCase,
            deleteProductUseCase = deleteProductUseCase,
            updateProductUseCase = updateProductUseCase,
            searchProductsUseCase = searchProductsUseCase
        )
    }

    @Test
    fun `getProductsUseCase should return product list`() = runTest(testDispatcher) {
        advanceUntilIdle()

        assertEquals(testProducts, viewModel.products.value)

        coVerify(exactly = 1) { getProductsUseCase() }
    }
}
