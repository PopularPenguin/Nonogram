package com.popularpenguin.nonogram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.popularpenguin.nonogram.ui.theme.NonogramTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.popularpenguin.nonogram.ui.*
import com.popularpenguin.nonogram.viewmodel.NonogramViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainActivityScreen() }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainActivityScreen() {
    NonogramTheme {
        Surface(color = MaterialTheme.colors.background) {

            val navController = rememberAnimatedNavController()
            val viewModel: NonogramViewModel = viewModel()

            AnimatedNavHost(navController = navController, startDestination = "title") {
                composable(
                    route = "title",
                    exitTransition = { _, _ ->
                        fadeOut(animationSpec = tween(1000))
                    }
                ) {
                    TitleScreen(navController = navController, viewModel = viewModel)
                }
                composable(
                    route = "nonogram",
                    enterTransition = { _, _ ->
                        fadeIn(animationSpec = tween(1000))
                    }
                ) {
                    NonogramScreen(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}