package com.denisbrandi.functionalusecases.di

import com.denisbrandi.functionalusecases.domain.model.SimpleResult
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import com.denisbrandi.functionalusecases.domain.repository.UserRepository
import com.denisbrandi.functionalusecases.domain.usecase.fp.getTransactions
import io.reactivex.Single

class FPGetTransactionUseCaseFactory(
    private val userRepository: UserRepository,
    private val transactionRepository: TransactionRepository
) {

    fun makeGetTransactionUseCase(): () -> Single<SimpleResult<List<Transaction>>> {
        return {
            getTransactions(
                { userRepository.getUser() },
                transactionRepository
            )
        }
    }

}