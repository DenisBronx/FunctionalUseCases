package com.denisbrandi.functionalusecases.domain.usecase.oop

import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.UserRepository

class GetUserUseCaseImpl(
    private val userRepository: UserRepository
) : GetUserUseCase {

    override fun invoke(): User = userRepository.getUser()
}