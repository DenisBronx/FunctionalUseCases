package com.denisbrandi.functionalusecases.di

import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import com.denisbrandi.functionalusecases.domain.repository.UserRepository
import com.denisbrandi.functionalusecases.domain.usecase.fp.GetTransactionsUseCase
import com.denisbrandi.functionalusecases.domain.usecase.fp.getTransactions

class FPGetTransactionUseCaseFactory(
    private val userRepository: UserRepository,
    private val transactionRepository: TransactionRepository
) {

    fun makeGetTransactionUseCase(): GetTransactionsUseCase {
        return {
            getTransactions(
                userRepository::getUser,
                transactionRepository
            )
        }
    }

}