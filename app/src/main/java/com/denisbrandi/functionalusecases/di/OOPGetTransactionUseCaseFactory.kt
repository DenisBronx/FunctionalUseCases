package com.denisbrandi.functionalusecases.di

import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import com.denisbrandi.functionalusecases.domain.repository.UserRepository
import com.denisbrandi.functionalusecases.domain.usecase.oop.GetTransactionsUseCase
import com.denisbrandi.functionalusecases.domain.usecase.oop.GetTransactionsUseCaseImpl
import com.denisbrandi.functionalusecases.domain.usecase.oop.GetUserUseCaseImpl

class OOPGetTransactionUseCaseFactory(
    private val userRepository: UserRepository,
    private val transactionRepository: TransactionRepository
) {

    fun makeGetTransactionUseCase(): GetTransactionsUseCase {
        return GetTransactionsUseCaseImpl(GetUserUseCaseImpl(userRepository), transactionRepository)
    }

}