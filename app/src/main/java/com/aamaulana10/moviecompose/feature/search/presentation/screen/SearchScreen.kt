package com.aamaulana10.moviecompose.feature.search.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aamaulana10.moviecompose.feature.home.presentation.component.GridMovieListView
import com.aamaulana10.moviecompose.feature.search.presentation.component.SearchBarView
import com.aamaulana10.moviecompose.feature.search.presentation.viewmodel.SearchViewModel

@Composable
fun SearchScreen(navHostController: NavHostController) {
    var viewModel = SearchViewModel()
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            SearchBarView(viewModel)

            Spacer(modifier = Modifier.height(8.dp))

            GridMovieListView(
                sectionTitle = "Result",
                movies = viewModel.movies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                navHostController
            )
        }
    }
}