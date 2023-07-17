package br.com.ocdev.assignment2.Utils

import br.com.ocdev.assignment2.model.User
import com.github.javafaker.Faker
import com.github.javafaker.Name
import kotlin.random.Random

object FakerSingleton {
    private val instance: Faker = Faker()

    fun getInstance(): Faker {
        return instance
    }
}

class GenFakeList {


     fun gen(): List<User> {
        val fake = FakerSingleton.getInstance()

        var listUsers = mutableListOf<User>()
        // Create a sequence generator that will generate given sequence
        val userGenerator = generateSequence {
            User(
                // postId is a 8 digit Long value
                userId = Random.nextLong(10000001, 88888888),
                userName = fake.name()?.username() ?: "",
                fullName = fake.name()?.fullName() ?: "",
                email = fake.internet().emailAddress()
            )
        }

        val users = userGenerator.take(100)
        users.forEach { listUsers.add(it) }
        return listUsers
    }
}