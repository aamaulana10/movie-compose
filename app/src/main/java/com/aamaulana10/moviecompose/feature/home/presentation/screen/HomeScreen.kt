package com.aamaulana10.moviecompose.feature.home.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aamaulana10.moviecompose.feature.home.presentation.component.GridMovieListView
import com.aamaulana10.moviecompose.feature.home.presentation.component.HorizontalMovieListView
import com.aamaulana10.moviecompose.feature.home.presentation.component.SearchBarView
import com.aamaulana10.moviecompose.feature.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navHostController: NavHostController) {

    val viewModel = HomeViewModel()

    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Black) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "iMovie",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            SearchBarView(navHostController)
            CategoryListView(viewModel)
            if (viewModel.selectedCategory == "All") {
                HorizontalMovieListView(
                    "Popular",
                    viewModel.popularMovies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                    navHostController
                )
                HorizontalMovieListView(
                    "Now Playing",
                    viewModel.nowPlayingMovies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                    navHostController
                )
                HorizontalMovieListView(
                    "Up Coming",
                    viewModel.upcomingMovies.observeAsState(initial = emptyList()).value.toMutableStateList(),
                    navHostController
                )
            } else {
                GridMovieListView(
                    viewModel.selectedCategory,
                    viewModel.movies.observeAsState(initial = emptyList()).value.toMutableStateList()
                )
            }
        }
    }
}

@Composable
fun CategoryListView(viewModel: HomeViewModel) {
    LazyRow(Modifier.padding(vertical = 8.dp)) {
        items(viewModel.categories) { category ->
            val color = if (viewModel.selectedCategory == category) {
                Color(0xFF4055C6)
            } else {
                Color.Transparent
            }
            Surface(
                onClick = { viewModel.updateCategory(category) },
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                color = color,
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }
}