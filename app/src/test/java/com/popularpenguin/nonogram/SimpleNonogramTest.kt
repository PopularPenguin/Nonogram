package com.popularpenguin.nonogram

import com.google.common.truth.Truth.assertThat
import com.popularpenguin.nonogram.model.*
import org.junit.Before
import org.junit.Test

class SimpleNonogramTest {

    lateinit var nonogram: Nonogram

    @Before
    fun setup() {
        val row1 = arrayOf(
            Cell(true).apply { content = Content.Filled },
            Cell(true).apply { content = Content.Filled },
            Cell(true).apply { content = Content.Filled }
        )
        val row2 = arrayOf(
            Cell(true).apply { content = Content.Filled },
            Cell(false).apply { content = Content.Empty },
            Cell(true).apply { content = Content.Filled }
        )
        val cells = arrayOf(row1, row2)

        nonogram = Nonogram(cells)
    }

    @Test
    fun checkRowAndColumnCount() {
        assertThat(nonogram.rowSize).isEqualTo(2)
        assertThat(nonogram.columnSize).isEqualTo(3)
    }

    @Test
    fun checkRowHintSize() {
        assertThat(nonogram.rowHints[0].size).isEqualTo(1)
        assertThat(nonogram.rowHints[1].size).isEqualTo(2)
    }

    @Test
    fun checkColumnHintSize() {
        assertThat(nonogram.columnHints[0].size).isEqualTo(1)
        assertThat(nonogram.columnHints[1].size).isEqualTo(1)
        assertThat(nonogram.columnHints[2].size).isEqualTo(1)
    }

    @Test
    fun checkPuzzleSolutionSolved() {
        val solution = nonogram.checkSolution()

        assertThat(solution).isInstanceOf(SolutionState.Solved::class.java)
    }
}