package br.com.ocdev.assignment_3.data.data_store

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.datastore by preferencesDataStore(name = "app_datastore")

class DataStoreManager @Inject constructor(
    @ApplicationContext val context: Context
) {
    private val populatedKey = booleanPreferencesKey("populated")

    val populated: Flow<Boolean> = context.datastore.data.map { preference ->
        preference[populatedKey] ?: false
    }

    suspend fun savePopulated(populated: Boolean) {
        context.datastore.edit { preference ->
            preference[populatedKey] = populated
        }
    }
}