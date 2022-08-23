package com.denisbrandi.functionalusecases.domain.usecase.fp

import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.model.User

fun interface GetTransactionsUseCase : suspend () -> Answer<List<Transaction>, Throwable>
fun interface GetUserUseCase : () -> User