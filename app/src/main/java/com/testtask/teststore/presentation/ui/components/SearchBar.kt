package com.testtask.teststore.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.testtask.teststore.R
import com.testtask.teststore.presentation.ui.theme.MyBlue

@Composable
fun SearchBar(searchQuery: String, onSearchChange: (String) -> Unit, onClear: () -> Unit) {
    TextField(
        value = searchQuery,
        onValueChange = onSearchChange,
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = onClear) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear")
                }
            }
        },
        placeholder = { Text(text = stringResource(R.string.search_for_products)) },
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Blue, RoundedCornerShape(8.dp))
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MyBlue,
            unfocusedContainerColor = MyBlue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
    )
}