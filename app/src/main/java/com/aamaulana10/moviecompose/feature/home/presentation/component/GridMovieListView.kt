package com.aamaulana10.moviecompose.feature.home.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import coil.compose.AsyncImage
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel

@Composable
fun GridMovieListView(sectionTitle: String, movies: List<MovieVideosModel>) {
    Column(
        Modifier
            .padding(vertical = 16.dp)
            .heightIn(max = movies.size * 250.dp)
    ) {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        AnimatedVisibility(
            visible = movies.isNotEmpty(),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LazyVerticalGrid(
                modifier = Modifier.padding(vertical = 8.dp),
                columns = GridCells.Fixed(2)
            ) {
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
                        )
                    }
                }
            }
        }
    }
}