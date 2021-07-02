package com.popularpenguin.nonogram.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.popularpenguin.nonogram.R
import com.popularpenguin.nonogram.prefsDataStore
import com.popularpenguin.nonogram.viewmodel.NonogramViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@Composable
fun TitleScreen(
    navController: NavController,
    viewModel: NonogramViewModel
) {
    val context = LocalContext.current
    val index = runBlocking {
        viewModel.getCurrentNonogramIndex(context.prefsDataStore)
    }
    val navigate: (String) -> Unit = { route ->
        navController.navigate(route = route)
    }

    Column(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color.LightGray, Color.Black, Color.Gray)
                )
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            modifier = Modifier,
            color = Color.White,
            text = stringResource(id = R.string.app_name),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            modifier = Modifier
                .border(
                    width = 6.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            colorResource(id = R.color.teal),
                            colorResource(id = R.color.blue)
                        )
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(shape = RoundedCornerShape(20.dp))
                .width(240.dp)
                .height(80.dp),
            onClick = {
                viewModel.setNonogram(index)
                navigate("nonogram")
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                val levelText = stringResource(id = R.string.title_level)
                Text(
                    text = "$levelText $index",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Preview
@Composable
fun TitleScreenPreview() {
    TitleScreen(rememberNavController(), viewModel())
}