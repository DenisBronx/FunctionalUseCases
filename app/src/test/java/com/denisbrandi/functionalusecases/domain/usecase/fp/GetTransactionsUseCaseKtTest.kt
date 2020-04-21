package com.denisbrandi.functionalusecases.domain.usecase.fp

import com.denisbrandi.functionalusecases.domain.model.Result
import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class GetTransactionsUseCaseKtTest {

    private val dummyUser = User("1234", "Jack Sparrow")
    private val repositoryResult = Result.Failure(Throwable())
    private val transactionRepository: TransactionRepository = mock {
        whenever(it.getTransactions(dummyUser.id)).thenReturn(Single.just(repositoryResult))
    }

    @Test
    fun `getTransactions should return transactionRepository result`() {
        val actual = getTransactions({ dummyUser }, transactionRepository).test()

        actual.assertValue { it === repositoryResult }
    }
}