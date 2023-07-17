package br.com.ocdev.assignment2.model

import br.com.ocdev.assignment2.Utils.FakerSingleton
import kotlin.random.Random

data class User(val userId: Long, val userName: String, val fullName: String, val email: String)