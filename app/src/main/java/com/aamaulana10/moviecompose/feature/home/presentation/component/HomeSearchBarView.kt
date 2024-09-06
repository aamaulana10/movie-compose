package com.aamaulana10.moviecompose.feature.home.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeSearchBarView(navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navHostController.navigate("search")
            }
            .padding(vertical = 8.dp), colors = CardDefaults.cardColors(
            containerColor = Color.Gray.copy(alpha = 0.2f)
        )
    ) {
        TextField(
            value = "Find movies, show, and more", onValueChange = {},
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
            enabled = false,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            }

        )
    }
}