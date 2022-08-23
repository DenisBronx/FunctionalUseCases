package com.denisbrandi.functionalusecases.domain.repository.fakes

import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository

class FakeTransactionRepository : TransactionRepository {
    lateinit var transactionsResult: Answer<List<Transaction>, Throwable>
    override suspend fun getTransactions(userId: String) = transactionsResult
}