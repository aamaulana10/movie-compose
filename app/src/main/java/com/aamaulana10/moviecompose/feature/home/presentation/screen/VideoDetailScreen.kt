package com.aamaulana10.moviecompose.feature.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.aamaulana10.moviecompose.feature.home.presentation.viewmodel.DetailViewModel
import com.aamaulana10.moviecompose.utils.ui.getScreenWidth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoDetailScreen(navHostController: NavHostController, videoId: String) {
    val viewModel = DetailViewModel(videoId)
    val movie = viewModel.movie.observeAsState(initial = null).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                ),
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                }
            )
        },
        modifier = Modifier.fillMaxSize(), containerColor = Color.Black
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            movie?.let {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500" + movie.backdrop_path,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .width(getScreenWidth())
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    ),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    ),
                )
                Text(
                    text = movie.popularity.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Normal
                    ),
                )
            }

        }
    }
}