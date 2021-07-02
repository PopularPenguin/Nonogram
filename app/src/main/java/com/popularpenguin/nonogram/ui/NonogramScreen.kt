package com.popularpenguin.nonogram.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.popularpenguin.nonogram.model.SolutionState
import com.popularpenguin.nonogram.viewmodel.NonogramViewModel
import com.popularpenguin.nonogram.R

@Composable
fun NonogramScreen(
    navController: NavController,
    viewModel: NonogramViewModel
) {
    // Go to next nonogram if there is one, else go to title
    if (viewModel.solutionState == SolutionState.Solved()) {
        val navigate: (String) -> Unit = { route ->
            navController.navigate(
                route = route,
                navOptions = NavOptions.Builder()
                    .setPopUpTo(route = route, inclusive = true)
                    .build()
            )
        }

        viewModel.next(context = LocalContext.current, navigate = navigate)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.LightGray, Color.Black, Color.Gray)
                )
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (viewModel.solutionState == SolutionState.Solved()) {
                StatusView(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(80.dp)
                )
            } else {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(80.dp),
                    text = "${viewModel.nonogramIndex}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(
                modifier = Modifier.height(80.dp)
            )
            Row {
                // scale size down slightly for each cell past 5 in a column
                val scale = 1.275f - 0.055f * viewModel.nonogram.cells.size

                RowHints(
                    hints = viewModel.nonogram.rowHints,
                    scale = scale,
                    modifier = Modifier.align(Alignment.Bottom)
                )
                Column {
                    ColumnHints(
                        hints = viewModel.nonogram.columnHints,
                        scale = scale
                    )
                    GridView(
                        cells = viewModel.nonogram.cells,
                        mode = viewModel.mode,
                        scale = scale,
                        onClick = viewModel::checkSolution
                    )
                }
            }
            Spacer(
                modifier = Modifier.height(80.dp)
            )
            ModeButtonRow(
                mode = viewModel.mode,
                changeMode = viewModel::changeMode
            )
        }
    }
}

// Show a message + circular indicator at the top if a nonogram is completed
@Composable
fun StatusView(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.solved_true),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        CircularProgressIndicator()
    }
}