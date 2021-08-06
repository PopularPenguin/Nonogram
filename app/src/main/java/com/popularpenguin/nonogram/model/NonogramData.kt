package com.popularpenguin.nonogram.model

object NonogramData {
    private val n0 = create(
        arrayOf(1, 1, 0, 1, 1),
        arrayOf(1, 0, 0, 0, 1),
        arrayOf(1, 0, 0, 0, 1),
        arrayOf(1, 0, 0, 0, 1),
        arrayOf(1, 1, 0, 1, 1)
    )
    private val n1 = create(
        arrayOf(1, 0, 0, 0, 1),
        arrayOf(1, 1, 1, 1, 1),
        arrayOf(0, 0, 1, 0, 1),
        arrayOf(1, 0, 1, 1, 1),
        arrayOf(1, 0, 1, 0, 1)
    )
    private val n2 = create(
        arrayOf(1, 1, 1, 0, 0),
        arrayOf(1, 0, 1, 0, 0),
        arrayOf(0, 1, 1, 0, 1),
        arrayOf(1, 0, 0, 1, 1),
        arrayOf(0, 0, 0, 1, 0)
    )
    private val n3 = create(
        arrayOf(1, 1, 1, 1, 1),
        arrayOf(0, 1, 1, 1, 0),
        arrayOf(1, 0, 0, 0, 1),
        arrayOf(0, 1, 1, 1, 1),
        arrayOf(1, 1, 1, 1, 0)
    )
    private val n4 = create(
        arrayOf(1, 1, 1, 0, 1, 1),
        arrayOf(1, 0, 1, 1, 1, 0),
        arrayOf(1, 0, 1, 0, 1, 1),
        arrayOf(0, 1, 0, 0, 1, 1),
        arrayOf(0, 1, 1, 1, 1, 0),
        arrayOf(1, 1, 1, 0, 1, 1)
    )
    private val n5 = create(
        arrayOf(0, 0, 1, 0, 0, 1),
        arrayOf(1, 1, 1, 0, 0, 1),
        arrayOf(0, 1, 0, 0, 1, 0),
        arrayOf(1, 1, 1, 1, 1, 1),
        arrayOf(1, 1, 1, 0, 1, 0),
        arrayOf(0, 1, 1, 1, 1, 0)
    )
    private val n6 = create(
        arrayOf(0, 1, 1, 0, 1, 0),
        arrayOf(1, 1, 0, 1, 0, 0),
        arrayOf(0, 1, 1, 1, 1, 0),
        arrayOf(1, 0, 1, 0, 1, 1),
        arrayOf(1, 0, 1, 1, 0, 0),
        arrayOf(1, 0, 0, 0, 0, 0)
    )
    private val n7 = create(
        arrayOf(0, 1, 1, 0, 1, 1),
        arrayOf(0, 1, 0, 0, 1, 0),
        arrayOf(1, 0, 0, 0, 0, 1),
        arrayOf(1, 1, 1, 0, 1, 1),
        arrayOf(1, 1, 1, 1, 0, 1),
        arrayOf(1, 0, 1, 0, 1, 0)
    )
    private val n8 = create(
        arrayOf(0, 0, 0, 0, 1, 0, 0),
        arrayOf(1, 0, 1, 1, 1, 0, 1),
        arrayOf(0, 0, 1, 1, 0, 1, 1),
        arrayOf(1, 1, 0, 1, 0, 1, 1),
        arrayOf(0, 1, 0, 0, 0, 0, 0),
        arrayOf(1, 1, 1, 1, 0, 0, 1),
        arrayOf(1, 0, 0, 0, 1, 1, 0)
    )
    private val n9 = create(
        arrayOf(1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 1, 0, 0, 0, 0, 0, 1),
        arrayOf(1, 1, 0, 0, 1, 0, 0, 1),
        arrayOf(1, 1, 0, 0, 1, 1, 1, 1),
        arrayOf(1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 1, 1, 1, 0, 1, 1, 1),
        arrayOf(0, 1, 1, 0, 1, 0, 1, 1),
        arrayOf(1, 0, 0, 0, 0, 1, 0, 0)
    )
    private val n10 = create(
        arrayOf(0, 1, 0, 1, 0, 1, 0, 1, 1),
        arrayOf(1, 0, 1, 1, 0, 1, 1, 0, 0),
        arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 1),
        arrayOf(1, 0, 0, 1, 1, 1, 0, 0, 1),
        arrayOf(1, 0, 1, 0, 0, 0, 0, 0, 1),
        arrayOf(1, 0, 0, 1, 1, 1, 0, 0, 1),
        arrayOf(1, 0, 0, 1, 0, 0, 1, 0, 0),
        arrayOf(1, 0, 1, 1, 0, 1, 1, 0, 0),
        arrayOf(0, 1, 0, 1, 0, 1, 0, 1, 1)
    )
    private val n11 = create(
        arrayOf(0, 1, 1, 0, 0, 1, 1, 1, 0, 1),
        arrayOf(0, 1, 1, 0, 0, 0, 0, 1, 0, 1),
        arrayOf(0, 1, 1, 0, 0, 1, 0, 1, 0, 1),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        arrayOf(1, 0, 0, 0, 0, 0, 0, 1, 0, 1),
        arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 1),
        arrayOf(0, 1, 1, 0, 0, 1, 0, 0, 0, 1),
        arrayOf(1, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        arrayOf(1, 0, 1, 0, 0, 1, 0, 1, 1, 1),
        arrayOf(0, 0, 1, 0, 0, 1, 0, 1, 0, 0)
    )
    private val n12 = create(
        arrayOf(1, 1, 1, 0, 1, 0, 1, 1, 1, 0),
        arrayOf(1, 1, 1, 1, 0, 1, 0, 1, 0, 1),
        arrayOf(0, 1, 0, 1, 0, 1, 0, 1, 0, 1),
        arrayOf(0, 1, 0, 1, 1, 1, 0, 1, 0, 1),
        arrayOf(0, 0, 0, 1, 1, 1, 0, 0, 0, 0),
        arrayOf(1, 1, 1, 0, 0, 1, 1, 1, 1, 0),
        arrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 0),
        arrayOf(0, 1, 0, 0, 0, 0, 1, 1, 1, 0),
        arrayOf(1, 1, 0, 0, 0, 0, 1, 1, 1, 1),
        arrayOf(1, 1, 1, 1, 1, 0, 0, 0, 1, 1)
    )
    private val n13 = create(
        arrayOf(0, 0, 0, 1, 1, 1, 1, 0, 0, 0),
        arrayOf(0, 1, 1, 1, 0, 0, 1, 1, 1, 0),
        arrayOf(1, 1, 1, 0, 0, 0, 0, 1, 1, 1),
        arrayOf(1, 1, 0, 0, 0, 0, 0, 0, 1, 1),
        arrayOf(1, 1, 0, 0, 1, 1, 1, 0, 1, 1),
        arrayOf(0, 1, 1, 0, 1, 1, 1, 1, 1, 0),
        arrayOf(0, 0, 1, 1, 1, 0, 1, 1, 1, 0),
        arrayOf(0, 0, 0, 1, 1, 1, 1, 0, 0, 0),
        arrayOf(0, 0, 1, 1, 0, 0, 1, 1, 0, 0),
        arrayOf(0, 1, 1, 0, 0, 0, 0, 1, 1, 0)
    )
    private val n14 = create(
        arrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 0),
        arrayOf(1, 1, 0, 0, 0, 0, 1, 1, 1, 0),
        arrayOf(1, 0, 0, 0, 0, 0, 1, 1, 1, 0),
        arrayOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 1),
        arrayOf(0, 0, 1, 1, 0, 0, 1, 1, 0, 0),
        arrayOf(1, 1, 1, 1, 1, 1, 1, 0, 1, 1),
        arrayOf(1, 1, 1, 0, 0, 0, 1, 1, 0, 1),
        arrayOf(1, 0, 1, 0, 1, 0, 1, 0, 1, 0),
        arrayOf(0, 1, 0, 1, 0, 1, 0, 1, 0, 1),
        arrayOf(1, 1, 1, 1, 0, 0, 1, 1, 1, 1)
    )
    private val n15 = create(
        arrayOf(1, 1, 1, 0, 0, 0, 0, 1, 1, 1),
        arrayOf(0, 1, 1, 1, 0, 0, 1, 1, 1, 0),
        arrayOf(0, 0, 1, 1, 1, 1, 1, 1, 0, 0),
        arrayOf(0, 1, 1, 1, 0, 0, 1, 1, 1, 0),
        arrayOf(1, 1, 1, 0, 0, 0, 0, 1, 1, 1),
        arrayOf(1, 1, 0, 0, 1, 1, 0, 0, 1, 1),
        arrayOf(1, 0, 0, 1, 0, 0, 1, 0, 0, 1),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0),
        arrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0),
        arrayOf(1, 0, 0, 1, 1, 1, 1, 0, 0, 1)
    )
    private val n16 = create(
        arrayOf(1, 1, 0, 0, 1, 1, 0, 0, 1, 1),
        arrayOf(1, 0, 0, 1, 1, 1, 1, 0, 0, 1),
        arrayOf(0, 0, 1, 1, 0, 0, 1, 1, 0, 0),
        arrayOf(0, 1, 1, 0, 1, 1, 0, 1, 1, 0),
        arrayOf(1, 1, 0, 1, 0, 0, 1, 0, 1, 1),
        arrayOf(1, 1, 0, 1, 0, 0, 1, 0, 1, 1),
        arrayOf(0, 1, 1, 0, 1, 1, 0, 1, 1, 0),
        arrayOf(0, 0, 1, 1, 0, 0, 1, 1, 0, 0),
        arrayOf(1, 0, 0, 1, 1, 1, 1, 0, 0, 1),
        arrayOf(1, 1, 0, 0, 1, 1, 0, 0, 1, 1)
    )
    private val n17 = create(
        arrayOf(1, 1, 1, 1, 0, 0, 1, 1, 1, 1),
        arrayOf(0, 1, 1, 0, 0, 0, 0, 1, 1, 0),
        arrayOf(1, 0, 0, 1, 0, 0, 1, 0, 0, 1),
        arrayOf(0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
        arrayOf(0, 0, 1, 1, 1, 1, 1, 1, 0, 0),
        arrayOf(1, 0, 1, 0, 1, 1, 0, 1, 0, 1),
        arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
        arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 1),
        arrayOf(0, 1, 0, 1, 1, 1, 1, 0, 1, 0),
        arrayOf(1, 1, 0, 0, 0, 0, 0, 0, 1, 1)
    )
    private val n18 = create(
        arrayOf(1, 1, 0, 0, 0, 0, 0, 0, 1, 1),
        arrayOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 1),
        arrayOf(0, 1, 1, 0, 1, 1, 0, 1, 1, 0),
        arrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
        arrayOf(0, 1, 1, 1, 0, 0, 1, 1, 1, 0),
        arrayOf(1, 1, 0, 0, 0, 0, 0, 0, 1, 1),
        arrayOf(1, 1, 0, 0, 0, 0, 0, 0, 1, 1),
        arrayOf(0, 1, 1, 0, 1, 1, 0, 1, 1, 0),
        arrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
        arrayOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 1)
    )
    private val n19 = create(
        arrayOf(0, 0, 0, 1, 1, 1, 1, 1, 0, 0),
        arrayOf(0, 0, 1, 1, 1, 1, 1, 1, 1, 0),
        arrayOf(0, 1, 1, 1, 0, 0, 0, 0, 1, 1),
        arrayOf(1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(1, 1, 1, 1, 0, 0, 0, 0, 1, 1),
        arrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
        arrayOf(0, 0, 1, 1, 1, 1, 1, 1, 0, 0),
        arrayOf(0, 0, 0, 1, 1, 1, 1, 0, 0, 0)
    )

    val nonograms = listOf(
        n0, n1, n2, n3, n4, n5, n6, n7, n8, n9,
        n10, n11, n12, n13, n14, n15, n16, n17, n18, n19
    )

    private fun create(vararg rows: Array<Int>): Nonogram {
        fun mapIntToCell(solved: Int) = Cell(solved == 1)

        val data = mutableListOf<Array<Cell>>()
        rows.forEach { row ->
            data.add(
                row.map(::mapIntToCell)
                    .toTypedArray()
            )
        }

        return Nonogram(cells = data.toTypedArray())
    }
}
