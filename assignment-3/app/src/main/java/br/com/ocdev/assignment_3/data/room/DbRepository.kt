package br.com.ocdev.assignment_3.data.room

import br.com.ocdev.assignment_3.data.room.dao.UserDao
import br.com.ocdev.assignment_3.data.room.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbRepository @Inject constructor(
    private val userDao: UserDao,
) {
    suspend fun insertAllUsers(user: List<User>) {
        return userDao.saveUsers(user)
    }

    suspend fun insertUser(user: User): Long {
        return userDao.saveUser(user)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    fun getAllUsersFlow(): Flow<List<User>> = userDao.getAllUsersFlow()

    suspend fun getUser(id: Int): User {
        return userDao.getUserById(id)
    }

    suspend fun deleteUser(user: User) {
        return userDao.deleteUser(user)
    }

}
