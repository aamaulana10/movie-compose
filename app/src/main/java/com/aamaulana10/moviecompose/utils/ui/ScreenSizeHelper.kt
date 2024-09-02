package com.aamaulana10.moviecompose.utils.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ScreenSize { SMALL, MEDIUM, LARGE }

@Composable
fun getScreenSize(): ScreenSize {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    return when {
        screenWidthDp < 600.dp -> ScreenSize.SMALL
        screenWidthDp < 840.dp -> ScreenSize.MEDIUM
        else -> ScreenSize.LARGE
    }
}

@Composable
fun getScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp.dp
}

@Composable
fun getScreenHeight(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp.dp
}
