package com.aamaulana10.moviecompose.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aamaulana10.moviecompose.feature.home.presentation.screen.HomeScreen
import com.aamaulana10.moviecompose.feature.home.presentation.screen.VideoDetailScreen
import com.aamaulana10.moviecompose.feature.search.presentation.screen.SearchScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable(
            "movie_detail/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.StringType })
        ) {
            val videoId = it.arguments?.getString("videoId") ?: ""
            VideoDetailScreen(navHostController = navController, videoId)
        }
        composable("search") {
            SearchScreen(navHostController = navController)
        }
    }

}