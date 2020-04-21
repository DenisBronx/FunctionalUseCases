package com.denisbrandi.functionalusecases.domain.usecase.oop

import com.denisbrandi.functionalusecases.domain.model.SimpleResult
import com.denisbrandi.functionalusecases.domain.model.Transaction
import io.reactivex.Single

interface GetTransactionsUseCase {

    operator fun invoke(): Single<SimpleResult<List<Transaction>>>

}