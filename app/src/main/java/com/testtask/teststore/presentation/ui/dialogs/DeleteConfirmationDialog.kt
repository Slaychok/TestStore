package com.testtask.teststore.presentation.ui.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.testtask.teststore.R
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
                Text(stringResource(R.string.yes), color = Color.Red)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.no), color = Color.Black)
            }
        },
        title = { Text(stringResource(R.string.removing_product)) },
        text = { Text(stringResource(R.string.do_you_want_to_delete, product.name)) }
    )
}