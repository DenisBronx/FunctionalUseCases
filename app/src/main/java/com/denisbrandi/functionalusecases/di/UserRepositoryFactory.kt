package com.denisbrandi.functionalusecases.di

import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.UserRepository

object UserRepositoryFactory {

    fun makeUserRepository(): UserRepository {
        return object : UserRepository {
            override fun getUser(): User {
                TODO("Not yet implemented")
            }
        }
    }

}