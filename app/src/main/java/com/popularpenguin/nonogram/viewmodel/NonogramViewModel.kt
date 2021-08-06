package com.popularpenguin.nonogram.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.popularpenguin.nonogram.PreferenceKeys
import com.popularpenguin.nonogram.model.Nonogram
import com.popularpenguin.nonogram.model.SolutionState
import com.popularpenguin.nonogram.prefsDataStore
import com.popularpenguin.nonogram.repository.NonogramRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NonogramViewModel
@Inject
constructor(
    repository: NonogramRepository,
    private val prefsDataStore: DataStore<Preferences>
) : ViewModel() {
    private val nonograms = repository.getNonograms()

    var nonogramIndex: Int by mutableStateOf(0)
        private set
    var nonogram: Nonogram by mutableStateOf(nonograms[nonogramIndex])
        private set
    var solutionState: SolutionState by mutableStateOf(SolutionState.Unsolved())
        private set
    var mode: Mode by mutableStateOf(Mode.Fill)
        private set

    fun setNonogram(index: Int) {
        nonogramIndex = index
        nonogram = nonograms[nonogramIndex]
    }

    suspend fun getCurrentNonogramIndex(): Int {
        nonogramIndex = prefsDataStore.data
            .map { prefs ->
                prefs[PreferenceKeys.LEVEL_INDEX] ?: 0
            }
            .first()

        return nonogramIndex
    }

    // Proceed to next nonogram
    fun next(context: Context, navigate: (String) -> Unit) {
        if (mode == Mode.Paused) return

        viewModelScope.launch {
            changeMode(Mode.Paused)

            delay(1000L)

            nonogram.reset()
            solutionState = SolutionState.Unsolved()
            if (nonogramIndex < nonograms.lastIndex) {
                nonogramIndex++
                updateLevelIndex(context)
                nonogram = nonograms[nonogramIndex]
            } else {
                navigate("title")
            }

            changeMode(Mode.Fill)
        }
    }

    fun reset() {
        nonogram.reset()
        // trigger a recomposition
        val currentMode = mode
        mode = Mode.Reset
        mode = currentMode
    }

    fun checkSolution() {
        solutionState = nonogram.checkSolution()
    }

    // Change user mode (from buttons)
    fun changeMode(newMode: Mode) {
        mode = newMode
    }

    private suspend fun updateLevelIndex(context: Context) {
        context.prefsDataStore.edit { prefs ->
            prefs[PreferenceKeys.LEVEL_INDEX] = nonogramIndex
        }
    }

    enum class Mode { Fill, Skip, Guess, Paused, Reset }
}