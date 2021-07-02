package com.popularpenguin.nonogram

import com.google.common.truth.Truth.assertThat
import com.popularpenguin.nonogram.model.Cell
import com.popularpenguin.nonogram.model.Nonogram
import org.junit.Before
import org.junit.Test

class ComplexNonogramTest {

    lateinit var nonogram: Nonogram

    @Before
    fun setup() {
        val row1 = listOf(1, 0, 0, 0, 1).map(::mapIntToCell).toTypedArray()
        val row2 = listOf(1, 1, 1, 1, 1).map(::mapIntToCell).toTypedArray()
        val row3 = listOf(0, 0, 1, 0, 1).map(::mapIntToCell).toTypedArray()
        val row4 = listOf(1, 0, 1, 1, 1).map(::mapIntToCell).toTypedArray()
        val row5 = listOf(1, 0, 1, 0, 1).map(::mapIntToCell).toTypedArray()
        val data = arrayOf(row1, row2, row3, row4, row5)

        nonogram = Nonogram(data)
    }

    fun mapIntToCell(solved: Int) = Cell(solved == 1)

    @Test
    fun checkRowAndColumnCount() {
        assertThat(nonogram.rowSize).isEqualTo(5)
        assertThat(nonogram.columnSize).isEqualTo(5)
    }

    @Test
    fun checkRowHintSize() {
        assertThat(nonogram.rowHints[0].size).isEqualTo(2)
        assertThat(nonogram.rowHints[1].size).isEqualTo(1)
        assertThat(nonogram.rowHints[2].size).isEqualTo(2)
        assertThat(nonogram.rowHints[3].size).isEqualTo(2)
        assertThat(nonogram.rowHints[4].size).isEqualTo(3)
    }

    @Test
    fun checkRowHintAmount() {
        val row1 = nonogram.rowHints[0]
        val row2 = nonogram.rowHints[1]
        val row3 = nonogram.rowHints[2]
        val row4 = nonogram.rowHints[3]
        val row5 = nonogram.rowHints[4]

        assertThat(row1).isEqualTo(arrayOf(1, 1))
        assertThat(row2).isEqualTo(arrayOf(5))
        assertThat(row3).isEqualTo(arrayOf(1, 1))
        assertThat(row4).isEqualTo(arrayOf(1, 3))
        assertThat(row5).isEqualTo(arrayOf(1, 1, 1))
    }

    @Test
    fun checkColumnHintSize() {
        assertThat(nonogram.columnHints[0].size).isEqualTo(2)
        assertThat(nonogram.columnHints[1].size).isEqualTo(1)
        assertThat(nonogram.columnHints[2].size).isEqualTo(1)
        assertThat(nonogram.columnHints[3].size).isEqualTo(2)
        assertThat(nonogram.columnHints[4].size).isEqualTo(1)
    }

    @Test
    fun checkColumnHintAmount() {
        val column1 = nonogram.columnHints[0]
        val column2 = nonogram.columnHints[1]
        val column3 = nonogram.columnHints[2]
        val column4 = nonogram.columnHints[3]
        val column5 = nonogram.columnHints[4]

        assertThat(column1).isEqualTo(arrayOf(2, 2))
        assertThat(column2).isEqualTo(arrayOf(1))
        assertThat(column3).isEqualTo(arrayOf(4))
        assertThat(column4).isEqualTo(arrayOf(1, 1))
        assertThat(column5).isEqualTo(arrayOf(5))
    }
}