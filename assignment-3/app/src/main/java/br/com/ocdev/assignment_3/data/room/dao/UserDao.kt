package br.com.ocdev.assignment_3.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import br.com.ocdev.assignment_3.data.room.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    // Save Users
    @Upsert
    suspend fun saveUsers(listUser: List<User>)

    //Save one user
    @Upsert
    suspend fun saveUser(user: User): Long

    //get all users
    @Query("SELECT * FROM User Order by userId ASC")
    suspend fun getAllUsers(): List<User>

    //get all users Flow
    @Query("SELECT * FROM User Order by userId ASC")
    fun getAllUsersFlow(): Flow<List<User>>

    //get user by id
    @Query("SELECT * FROM User Where userId=:id")
    suspend fun getUserById(id: Int): User

    //delete one user
    @Delete
    suspend fun deleteUser(user: User)

    //delete all users
    @Query("DELETE FROM User")
    suspend fun deleteAllUsers()

}