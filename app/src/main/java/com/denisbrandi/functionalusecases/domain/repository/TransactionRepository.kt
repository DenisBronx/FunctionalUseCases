package com.denisbrandi.functionalusecases.domain.repository

import com.denisbrandi.functionalusecases.domain.model.SimpleResult
import com.denisbrandi.functionalusecases.domain.model.Transaction
import io.reactivex.Single

interface TransactionRepository {

    fun getTransactions(userId: String): Single<SimpleResult<List<Transaction>>>

}