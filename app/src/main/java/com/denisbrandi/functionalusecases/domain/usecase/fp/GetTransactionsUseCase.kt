package com.denisbrandi.functionalusecases.domain.usecase.fp

import com.denisbrandi.functionalusecases.domain.model.SimpleResult
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import io.reactivex.Single

inline fun getTransactions(
    getUserUseCase: GetUserUseCase,
    transactionRepository: TransactionRepository
): Single<SimpleResult<List<Transaction>>> {
    return transactionRepository.getTransactions(getUserUseCase().id)
}

typealias GetTransactionsUseCase = () -> Single<SimpleResult<List<Transaction>>>