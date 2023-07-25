package br.com.ocdev.assignment_3.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.ocdev.assignment_3.data.room.dao.UserDao
import br.com.ocdev.assignment_3.data.room.model.User

@Database(
    version = 1,
    entities = [User::class],
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}