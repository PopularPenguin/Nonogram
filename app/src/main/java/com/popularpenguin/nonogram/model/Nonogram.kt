package com.popularpenguin.nonogram.model

class Nonogram(val cells: Array<Array<Cell>>, val id: Int = 0) {

    val rowSize = cells.size
    val columnSize = cells[0].size

    val rowHints = Array(rowSize) { i -> hintCount(cells[i]) }
    val columnHints = Array(columnSize) { i ->
        val currentCells = mutableListOf<Cell>()

        for (row in 0 until rowSize) {
            currentCells.add(cells[row][i])
        }

        columnCount(currentCells.toTypedArray())
    }

    fun checkSolution(): SolutionState {
        var errorCount = 0
        var emptyCount = 0

        for (row in cells) {
            for (cell in row) {
                if (!cell.isSolution && cell.content == Content.Filled) {
                    errorCount++
                } else if (cell.isSolution && cell.content == Content.Empty) {
                    emptyCount++
                } else if (cell.isSolution && cell.content == Content.Guess) {
                    emptyCount++
                } else if (cell.isSolution && cell.content == Content.Skip) {
                    errorCount++
                }
            }
        }

        return when {
            errorCount > 0 -> SolutionState.Error(errorCount)
            emptyCount > 0 -> SolutionState.Unsolved()

            else -> SolutionState.Solved()
        }
    }

    fun reset() {
        for (row in cells) {
            for (cell in row) {
                cell.content = Content.Empty
            }
        }
    }

    private fun hintCount(cells: Array<Cell>): Array<Int> {
        val hints = mutableListOf<Int>()
        var counter = 0

        for ((index, cell) in cells.withIndex()) {
            if (cell.isSolution) {
                counter++
                if (index == cells.lastIndex) {
                    hints.add(counter)
                }
            } else {
                hints.add(counter)
                counter = 0
            }
        }

        return if (hints.isEmpty()) {
            arrayOf(0)
        } else {
            val hintArray = hints.filter { it > 0 }.toTypedArray()

            hintArray
        }
    }

    private fun columnCount(cells: Array<Cell>): Array<Int> {
        return hintCount(cells)
    }
}

sealed class SolutionState(message: Message) {
    enum class Message { Solved, Unfilled, Error }

    data class Solved(val message: String = "Solved") : SolutionState(Message.Solved)
    data class Unsolved(val message: String = "Unsolved") : SolutionState(Message.Unfilled)
    data class Error(val errorCount: Int) : SolutionState(Message.Error)
}