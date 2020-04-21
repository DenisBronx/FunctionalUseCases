package com.denisbrandi.functionalusecases.domain.usecase.oop

import com.denisbrandi.functionalusecases.domain.model.SimpleResult
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import io.reactivex.Single

class GetTransactionsUseCaseImpl(
    private val getUserUseCase: GetUserUseCase,
    private val transactionRepository: TransactionRepository
) : GetTransactionsUseCase {

    override fun invoke(): Single<SimpleResult<List<Transaction>>> {
        return transactionRepository.getTransactions(getUserUseCase().id)
    }

}