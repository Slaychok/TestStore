package com.testtask.teststore.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.testtask.teststore.domain.model.Product
import com.testtask.teststore.presentation.ui.components.ClearFocusContainer
import com.testtask.teststore.presentation.ui.components.ProductItem
import com.testtask.teststore.presentation.ui.components.SearchBar
import com.testtask.teststore.presentation.ui.dialogs.DeleteConfirmationDialog
import com.testtask.teststore.presentation.ui.dialogs.EditQuantityDialog
import com.testtask.teststore.presentation.ui.theme.MyBlueBack
import com.testtask.teststore.presentation.viewmodels.ProductViewModel

@Composable
fun ProductScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val products by viewModel.products.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    var productToDelete by remember { mutableStateOf<Product?>(null) }
    var productToEdit by remember { mutableStateOf<Product?>(null) }

    ClearFocusContainer(
        modifier = modifier
            .fillMaxSize()
            .background(MyBlueBack)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SearchBar(
                searchQuery = searchQuery,
                onSearchChange = { viewModel.searchProducts(it) },
                onClear = { viewModel.searchProducts("") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        onDelete = { productToDelete = product },
                        onUpdate = { productToEdit = product }
                    )
                }
            }
        }
    }

    productToDelete?.let {
        DeleteConfirmationDialog(
            product = it,
            onDismiss = { productToDelete = null },
            onConfirm = {
                viewModel.deleteProduct(it)
                productToDelete = null
            }
        )
    }

    productToEdit?.let {
        EditQuantityDialog(
            product = it,
            onDismiss = { productToEdit = null },
            onConfirm = { newQuantity ->
                viewModel.updateProduct(it.copy(amount = newQuantity))
                productToEdit = null
            }
        )
    }
}

