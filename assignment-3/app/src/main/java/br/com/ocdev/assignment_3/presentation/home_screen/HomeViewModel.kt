package br.com.ocdev.assignment_3.presentation.home_screen

import br.com.ocdev.assignment_3.utils.GenFakeData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ocdev.assignment_3.data.data_store.DataStoreRepository
import br.com.ocdev.assignment_3.data.room.DbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dbRepository: DbRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    fun insertAllUsers() = viewModelScope.launch {
        dbRepository.insertAllUsers(GenFakeData().genUsersList())
    }

    val populated: StateFlow<Boolean> = dataStoreRepository.dbIsPopulated.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = false
    )
    fun saveIfDbIsPopulated(isPopulated: Boolean) = viewModelScope.launch {
        dataStoreRepository.saveIfDbIsPopulated(populated = isPopulated)
    }


}