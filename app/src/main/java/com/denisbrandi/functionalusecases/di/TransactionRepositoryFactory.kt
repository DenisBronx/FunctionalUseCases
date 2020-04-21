package com.denisbrandi.functionalusecases.di

import com.denisbrandi.functionalusecases.domain.model.SimpleResult
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import io.reactivex.Single

object TransactionRepositoryFactory {

    fun makeTransactionRepository(): TransactionRepository {
        return object : TransactionRepository {
            override fun getTransactions(userId: String): Single<SimpleResult<List<Transaction>>> {
                TODO("Not yet implemented")
            }
        }
    }

}