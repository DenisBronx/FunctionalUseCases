package com.denisbrandi.functionalusecases.domain.usecase

import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import com.denisbrandi.functionalusecases.domain.usecase.fp.GetTransactionsUseCase
import com.denisbrandi.functionalusecases.domain.usecase.fp.GetUserUseCase

class GetTransactionsUseCaseImpl(
    private val getUserUseCase: GetUserUseCase,
    private val transactionRepository: TransactionRepository
) : GetTransactionsUseCase {
    override suspend fun invoke(): Answer<List<Transaction>, Throwable> {
        return transactionRepository.getTransactions(getUserUseCase().id)
    }
}