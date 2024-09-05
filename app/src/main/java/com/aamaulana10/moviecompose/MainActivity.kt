package com.aamaulana10.moviecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aamaulana10.moviecompose.ui.theme.MoviecomposeTheme
import com.aamaulana10.moviecompose.utils.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviecomposeTheme {
                AppNavigation()
            }
        }
    }
}
