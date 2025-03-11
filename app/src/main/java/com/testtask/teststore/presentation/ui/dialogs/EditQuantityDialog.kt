package com.testtask.teststore.presentation.ui.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.testtask.teststore.domain.model.Product

@Composable
fun EditQuantityDialog(
    product: Product,
    onDismiss: () -> Unit,
    onConfirm: (Int) -> Unit
) {
    var quantity by remember { mutableStateOf(product.amount) }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { onConfirm(quantity) }) {
                Text("Принять", color = Color.Blue)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена", color = Color.Black)
            }
        },
        title = { Text("Количество товара") },
        text = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { if (quantity > 0) quantity-- }) {
                    Icon(
                        imageVector = Icons.Filled.Remove,
                        contentDescription = "Уменьшить"
                    )
                }

                Text(text = "$quantity", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                IconButton(onClick = { quantity++ }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Увеличить"
                    )
                }
            }
        }
    )
}