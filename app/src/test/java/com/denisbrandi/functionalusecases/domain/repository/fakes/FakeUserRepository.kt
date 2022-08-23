package com.denisbrandi.functionalusecases.domain.repository.fakes

import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.UserRepository

class FakeUserRepository : UserRepository {
    lateinit var userResult: User
    override fun getUser() = userResult
}