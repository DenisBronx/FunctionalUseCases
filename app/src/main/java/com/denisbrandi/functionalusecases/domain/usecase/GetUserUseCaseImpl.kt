package com.denisbrandi.functionalusecases.domain.usecase

import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.UserRepository
import com.denisbrandi.functionalusecases.domain.usecase.fp.GetUserUseCase

class GetUserUseCaseImpl(
    private val userRepository: UserRepository
) : GetUserUseCase {

    override fun invoke(): User = userRepository.getUser()
}