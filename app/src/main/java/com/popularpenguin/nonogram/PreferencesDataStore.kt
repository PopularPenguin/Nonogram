package com.popularpenguin.nonogram

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.prefsDataStore by preferencesDataStore("prefs")

object PreferenceKeys {
    val LEVEL_INDEX = intPreferencesKey("level_index")
}