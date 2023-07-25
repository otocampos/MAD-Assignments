package br.com.ocdev.assignment_3.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Long?= null,
    @ColumnInfo(name = "user_name")
    val userName: String?=null,
    val fullName: String?=null,
    val email: String?=null
)