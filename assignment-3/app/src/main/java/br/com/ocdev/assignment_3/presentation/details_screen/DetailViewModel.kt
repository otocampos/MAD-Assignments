package br.com.ocdev.assignment_3.presentation.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ocdev.assignment_3.data.room.DbRepository
import br.com.ocdev.assignment_3.data.room.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val dbRepository: DbRepository,
) : ViewModel() {
    private var _user = MutableStateFlow<User>(User())
    val user: StateFlow<User> get() = _user
    fun getUser(id: Int) = viewModelScope.launch {
        val user = dbRepository.getUser(id)
        _user.value = user
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        dbRepository.deleteUser(user)
    }


}