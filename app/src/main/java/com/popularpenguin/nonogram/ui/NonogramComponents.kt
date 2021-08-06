package com.popularpenguin.nonogram.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.popularpenguin.nonogram.R
import com.popularpenguin.nonogram.model.*
import com.popularpenguin.nonogram.viewmodel.NonogramViewModel

// the view for the nonogram + its hints
@Composable
fun GridView(
    cells: Array<Array<Cell>>,
    mode: NonogramViewModel.Mode,
    scale: Float = 1f,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Black
                )
            )
    ) {
        Column {
            for (row in cells) {
                Row {
                    for (cell in row) {
                        CellView(
                            cell = cell,
                            mode = mode,
                            scale = scale,
                            onClick = onClick
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowHints(
    hints: Array<Array<Int>>,
    modifier: Modifier = Modifier,
    scale: Float = 1f,
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ) {
        for (row in hints) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.align(Alignment.End)
            ) {
                if (row.isEmpty()) {
                    HintCell(value = 0, scale = scale)
                } else {
                    for (hint in row) {
                        HintCell(value = hint, scale = scale)
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnHints(
    hints: Array<Array<Int>>,
    scale: Float = 1f,
) {
    Row {
        for (column in hints) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.align(Alignment.Bottom)
            ) {
                if (column.isEmpty()) {
                    HintCell(value = 0, scale = scale)
                } else {
                    for (hint in column) {
                        HintCell(value = hint, scale = scale)
                    }
                }
            }
        }
    }
}

// base composable hint cell used by RowHints + ColumnHints
@Composable
fun HintCell(
    value: Int,
    scale: Float = 1f
) {
    val cellSize = 40.dp * scale

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(cellSize)
            .background(
                Brush.linearGradient(colors = listOf(Color.White, Color.Yellow, Color.Gray))
            )
            .border(
                BorderStroke(1.dp, Color.Gray)
            )
    ) {
        Text(
            text = "$value",
            textAlign = TextAlign.Center,
            fontSize = 26.sp * scale,
            fontWeight = FontWeight.SemiBold
        )
    }
}

// individual clickable nonogram cell
@Composable
fun CellView(
    cell: Cell,
    mode: NonogramViewModel.Mode,
    scale: Float = 1f,
    onClick: () -> Unit
) {
    var content: Content by remember { mutableStateOf(cell.content) }

    val background = when (content) {
        Content.Filled -> Brush.linearGradient(
            colors = listOf(Color.LightGray, Color.Black, Color.Gray)
        )

        else -> Brush.linearGradient(
            colors = listOf(Color.White, Color.LightGray, Color.White)
        )
    }
    val cellSize = 40.dp * scale

    Column {
        Box(
            modifier = Modifier
                .size(cellSize)
                .background(background)
                .border(
                    BorderStroke(
                        1.dp,
                        SolidColor(Color.Gray)
                    )
                )
                .clickable {
                    when (mode) {
                        NonogramViewModel.Mode.Fill -> {
                            when (cell.content) {
                                Content.Filled -> cell.content = Content.Empty
                                else -> cell.content = Content.Filled
                            }
                        }
                        NonogramViewModel.Mode.Skip -> {
                            when (cell.content) {
                                Content.Skip -> cell.content = Content.Empty
                                else -> cell.content = Content.Skip
                            }
                        }
                        NonogramViewModel.Mode.Guess -> {
                            when (cell.content) {
                                Content.Guess -> cell.content = Content.Empty
                                else -> cell.content = Content.Guess
                            }
                        }
                        else -> { /* do nothing, screen is paused */ }
                    }

                    content = cell.content
                    onClick()
                }
        ) {
            // add an Icon inside the box for skip 'X's and guesses
            when (cell.content) {
                Content.Skip -> Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(35.dp * scale),
                    painter = painterResource(id = R.drawable.x),
                    contentDescription = null
                )
                Content.Guess -> Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(35.dp * scale),
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null
                )

                else -> { /* No Icon */ }
            }
        }
    }

    content = cell.content
}

// bottom row of buttons to toggle fill, skip, and guess modes
@Composable
fun ModeButtonRow(
    mode: NonogramViewModel.Mode,
    changeMode: (NonogramViewModel.Mode) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        FillButton(
            mode = mode,
            changeMode = changeMode
        )
        Spacer(modifier = Modifier.width(20.dp))
        SkipButton(
            mode = mode,
            changeMode = changeMode
        )
        Spacer(modifier = Modifier.width(20.dp))
        GuessButton(
            mode = mode,
            changeMode = changeMode
        )
    }
}

@Composable
fun FillButton(
    mode: NonogramViewModel.Mode,
    changeMode: (NonogramViewModel.Mode) -> Unit
) {
    val borderColor = when (mode) {
        NonogramViewModel.Mode.Fill -> Color.Red

        else -> Color.Black
    }

    ModeButton(
        mode = NonogramViewModel.Mode.Fill,
        changeMode = changeMode,
        brush = Brush.linearGradient(
            colors = listOf(Color.LightGray, Color.Black, Color.Gray)
        ),
        borderColor = borderColor,
        label = stringResource(id = R.string.button_fill)
    )
}

@Composable
fun SkipButton(
    mode: NonogramViewModel.Mode,
    changeMode: (NonogramViewModel.Mode) -> Unit
) {
    val borderColor = when (mode) {
        NonogramViewModel.Mode.Skip -> Color.Red

        else -> Color.Black
    }

    ModeButton(
        mode = NonogramViewModel.Mode.Skip,
        changeMode = changeMode,
        brush = Brush.linearGradient(
            colors = listOf(Color.White, Color.LightGray, Color.White)
        ),
        borderColor = borderColor,
        iconResId = R.drawable.x,
        label = stringResource(id = R.string.button_skip)
    )
}

@Composable
fun GuessButton(
    mode: NonogramViewModel.Mode,
    changeMode: (NonogramViewModel.Mode) -> Unit
) {
    val borderColor = when (mode) {
        NonogramViewModel.Mode.Guess -> Color.Red

        else -> Color.Black
    }

    ModeButton(
        mode = NonogramViewModel.Mode.Guess,
        changeMode = changeMode,
        brush = Brush.linearGradient(
            colors = listOf(Color.White, Color.LightGray, Color.White)
        ),
        borderColor = borderColor,
        iconResId = R.drawable.circle,
        label = stringResource(id = R.string.button_guess)
    )
}

// base composable for a mode button
@Composable
fun ModeButton(
    mode: NonogramViewModel.Mode,
    changeMode: (NonogramViewModel.Mode) -> Unit,
    brush: Brush,
    borderColor: Color,
    iconResId: Int? = null,
    label: String = ""
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            modifier = Modifier
                .background(brush = brush, shape = CircleShape)
                .border(width = 2.dp, color = borderColor, shape = CircleShape)
                .size(80.dp),
            onClick = {
                if (mode != NonogramViewModel.Mode.Paused) {
                    changeMode(mode)
                }
            }
        ) {
            iconResId?.let {
                Icon(
                    modifier = Modifier.size(70.dp),
                    painter = painterResource(id = iconResId),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = label,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}

// reset the current nonogram
@Composable
fun ResetButton(viewModel: NonogramViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            modifier = Modifier
                .background(brush = Brush.linearGradient(
                    colors = listOf(Color.White, Color.LightGray)
                ), shape = CircleShape),
            onClick = {
                if (viewModel.mode != NonogramViewModel.Mode.Paused) {
                    viewModel.reset()
                }
            }
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.reset),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.button_reset),
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }

}