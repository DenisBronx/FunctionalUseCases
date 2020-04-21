package com.denisbrandi.functionalusecases.domain.repository

import com.denisbrandi.functionalusecases.domain.model.User

interface UserRepository {

    fun getUser(): User

}