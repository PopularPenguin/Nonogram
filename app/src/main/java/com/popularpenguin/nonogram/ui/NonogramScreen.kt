package com.popularpenguin.nonogram.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
            .horizontalScroll(state = rememberScrollState())
            .verticalScroll(state = rememberScrollState())
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ){
            Header(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                viewModel = viewModel
            )
            Spacer(
                modifier = Modifier.height(60.dp)
            )
            Body(viewModel = viewModel)
            Spacer(
                modifier = Modifier.height(60.dp)
            )
            Footer(viewModel = viewModel)
        }
    }
}

@Composable
fun Header(
    modifier: Modifier = Modifier,
    viewModel: NonogramViewModel
) {
    ResetButton(viewModel = viewModel)
    if (viewModel.solutionState == SolutionState.Solved()) {
        StatusView(
            modifier = modifier.height(80.dp)
        )
    } else {
            Text(
                modifier = modifier.height(80.dp),
                text = "${viewModel.nonogramIndex}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                textAlign = TextAlign.Center
            )
    }
}

@Composable
fun Body(viewModel: NonogramViewModel) {
    Row {
        // scale size down slightly for each cell past 5 in a column
        val scale = 1.3f - 0.07f * viewModel.nonogram.cells.size

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
}

@Composable
fun Footer(viewModel: NonogramViewModel) {
    ModeButtonRow(
        mode = viewModel.mode,
        changeMode = viewModel::changeMode
    )
}

// Show a message + circular indicator at the top if a nonogram is completed
@Composable
fun StatusView(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.solved_true),
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(16.dp))
        CircularProgressIndicator()
    }
}