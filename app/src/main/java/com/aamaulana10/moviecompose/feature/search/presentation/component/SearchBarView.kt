package com.aamaulana10.moviecompose.feature.search.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.aamaulana10.moviecompose.feature.search.presentation.viewmodel.SearchViewModel

@Composable
fun SearchBarView(viewModel: SearchViewModel) {

    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    var query by remember {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), colors = CardDefaults.cardColors(
            containerColor = Color.Gray.copy(alpha = 0.2f)
        )
    ) {
        TextField(
            value = query,
            onValueChange = { value ->
                query = value
            },
            placeholder = {
                Text(text = "Find movies, show, and more", color = Color.Gray)
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.Gray,
                disabledContainerColor = Color.Transparent,
                disabledTextColor = Color.Gray,
                disabledLeadingIconColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    println(query)
                    focusManager.clearFocus()
                    viewModel.searchVideos(query)
                    query = ""
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = if (query.isNotEmpty()) {
                {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            query = ""
                        })
                }
            } else {
                null
            }


        )
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}