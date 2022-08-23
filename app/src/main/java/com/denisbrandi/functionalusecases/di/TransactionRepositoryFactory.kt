package com.denisbrandi.functionalusecases.di

import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository

object TransactionRepositoryFactory {

    fun makeTransactionRepository(): TransactionRepository {
        return object : TransactionRepository {
            override suspend fun getTransactions(userId: String): Answer<List<Transaction>, Throwable> {
                TODO("Not yet implemented")
            }
        }
    }

}