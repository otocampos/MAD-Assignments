package br.com.ocdev.assignment_3.utils

import br.com.ocdev.assignment_3.data.room.model.User
import com.github.javafaker.Faker

object FakerSingleton {
    private val instance: Faker = Faker()

    fun getInstance(): Faker {
        return instance
    }
}

class GenFakeData {


    fun genUsersList(): List<User> {
        val fake = FakerSingleton.getInstance()

        // Create a sequence generator that will generate given sequence
        val userGenerator = generateSequence {
            User(
                // postId is a 8 digit Long value
                userName = fake.name()?.username() ?: "",
                fullName = fake.name()?.fullName() ?: "",
                email = fake.internet().emailAddress()
            )
        }


        return userGenerator.take(5).toList()
    }

    fun genUser(): User {
        val fake = FakerSingleton.getInstance()

        return User(
            // postId is a 8 digit Long value
            userName = fake.name()?.username() ?: "",
            fullName = fake.name()?.fullName() ?: "",
            email = fake.internet().emailAddress()
        )

    }
}