package com.popularpenguin.nonogram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.popularpenguin.nonogram.ui.theme.NonogramTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

@Composable
fun MainActivityScreen() {
    NonogramTheme {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            val viewModel: NonogramViewModel = viewModel()

            NavHost(navController = navController, startDestination = "title") {
                composable("title") {
                    TitleScreen(navController = navController, viewModel = viewModel)
                }
                composable("nonogram") {
                    NonogramScreen(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}