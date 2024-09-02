package com.aamaulana10.moviecompose.feature.home.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.feature.home.presentation.viewmodel.HomeViewModel
import com.aamaulana10.moviecompose.utils.ui.getScreenWidth

@Composable
fun HomeScreen() {

    val viewModel = HomeViewModel()
    viewModel.getPopularMovies()
    var movies =
        viewModel.popularMovies.observeAsState(initial = emptyList()).value.toMutableStateList()

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
            SearchBar()
            CategoryListView()
            PopularMovieListView(movies)
            PopularMovieListView(movies)
            PopularMovieListView(movies)
            PopularMovieListView(movies)
        }
    }
}

@Composable
fun SearchBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp), colors = CardDefaults.cardColors(
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
                unfocusedTextColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            }
        )
    }
}

@Composable
fun CategoryListView() {
    val categories = listOf("Popular", "Now Playing", "Top Rated", "Upcoming")
    LazyRow(Modifier.padding(vertical = 16.dp)) {
        items(categories) { category ->
            Surface(
                onClick = { println(category) },
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                color = Color(color = 0xFF4055C6),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    ),
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun PopularMovieListView(movies: List<MovieVideosModel>) {
    Column(Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Popular Movies",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        )
        LazyRow(Modifier.padding(vertical = 8.dp)) {
            if (movies.isEmpty()) {
                item {
                    Text(text = "No Movies found.")
                }
            } else {
                items(movies) { movie ->
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500" + movie.poster_path,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(all = 4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .width(getScreenWidth() / 3)
                    )
                }
            }
        }
    }
}