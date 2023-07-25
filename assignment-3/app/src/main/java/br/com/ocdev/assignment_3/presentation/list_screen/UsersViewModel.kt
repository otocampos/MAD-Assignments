package br.com.ocdev.assignment_3.presentation.list_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ocdev.assignment_3.data.room.DbRepository
import br.com.ocdev.assignment_3.data.room.model.User
import br.com.ocdev.assignment_3.utils.GenFakeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val dbRepository: DbRepository,
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> get() = _users.asStateFlow()


    init {
        getAllUsersFlow()

    }

    fun addUser() = viewModelScope.launch {
        dbRepository.insertUser(GenFakeData().genUser())
    }

    private fun listAllUsers() = viewModelScope.launch {
        val users = dbRepository.getAllUsers()

    }

    fun getAllUsersFlow() = viewModelScope.launch {
        dbRepository.getAllUsersFlow().collect { users ->
            _users.value = users
        }
    }

}