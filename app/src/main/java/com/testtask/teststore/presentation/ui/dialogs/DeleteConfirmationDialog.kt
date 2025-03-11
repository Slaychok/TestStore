package com.testtask.teststore.presentation.ui.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.testtask.teststore.domain.model.Product

@Composable
fun DeleteConfirmationDialog(
    product: Product,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("Да", color = Color.Red)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Нет", color = Color.Black)
            }
        },
        title = { Text("Удаление товара") },
        text = { Text("Вы действительно хотите удалить \"${product.name}\"?") }
    )
}