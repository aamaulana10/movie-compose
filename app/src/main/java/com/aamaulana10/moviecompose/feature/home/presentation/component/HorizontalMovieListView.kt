package com.aamaulana10.moviecompose.feature.home.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.aamaulana10.moviecompose.feature.home.core.domain.model.MovieVideosModel
import com.aamaulana10.moviecompose.utils.ui.getScreenWidth

@Composable
fun HorizontalMovieListView(
    sectionTitle: String,
    movies: List<MovieVideosModel>,
    navHostController: NavHostController
) {
    Column(Modifier.padding(vertical = 16.dp)) {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
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
                            .clickable {
                                navHostController.navigate("movie_detail/${movie.id}")
                            }
                    )
                }
            }
        }
    }
}