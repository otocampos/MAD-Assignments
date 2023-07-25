package br.com.ocdev.assignment_3.data.data_store

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepository @Inject constructor(
    private val dataStoreManager: DataStoreManager
) {
    val dbIsPopulated = dataStoreManager.populated

    suspend fun saveIfDbIsPopulated(populated: Boolean) {
        dataStoreManager.savePopulated(populated = populated)
    }
}