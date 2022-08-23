package com.denisbrandi.functionalusecases.domain.repository

import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.Transaction

interface TransactionRepository {

    suspend fun getTransactions(userId: String): Answer<List<Transaction>, Throwable>

}