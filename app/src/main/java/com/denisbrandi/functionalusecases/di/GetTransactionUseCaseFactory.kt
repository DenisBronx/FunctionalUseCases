package com.denisbrandi.functionalusecases.di

import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import com.denisbrandi.functionalusecases.domain.repository.UserRepository
import com.denisbrandi.functionalusecases.domain.usecase.GetTransactionsUseCaseImpl

class GetTransactionUseCaseFactory(
    private val userRepository: UserRepository,
    private val transactionRepository: TransactionRepository
) {

    fun makeGetTransactionUseCase(): GetTransactionsUseCaseImpl {
        return GetTransactionsUseCaseImpl(userRepository::getUser, transactionRepository)
    }

}