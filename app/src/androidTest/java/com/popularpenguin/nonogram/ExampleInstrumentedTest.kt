package com.popularpenguin.nonogram

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.popularpenguin.nonogram.model.Cell
import com.popularpenguin.nonogram.model.Nonogram

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    lateinit var cells : Array<Array<Cell>>
    @Before
    fun setUp() {
        val row1 = arrayOf(
            Cell(true),
            Cell(true),
            Cell(true)
        )
        val row2 = arrayOf(
            Cell(true),
            Cell(false),
            Cell(true)
        )

        cells = arrayOf(row1, row2)
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        //assertEquals("com.popularpenguin.nonogram", appContext.packageName)
        val puzzle = Nonogram(cells)

        Log.d("TEST", puzzle.rowHints.toString())

    }
}