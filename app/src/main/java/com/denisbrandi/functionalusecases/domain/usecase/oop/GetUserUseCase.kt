package com.denisbrandi.functionalusecases.domain.usecase.oop

import com.denisbrandi.functionalusecases.domain.model.User

interface GetUserUseCase {

    operator fun invoke(): User

}