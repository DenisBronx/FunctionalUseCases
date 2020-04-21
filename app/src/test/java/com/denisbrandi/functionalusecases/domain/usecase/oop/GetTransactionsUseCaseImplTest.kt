package com.denisbrandi.functionalusecases.domain.usecase.oop

import com.denisbrandi.functionalusecases.domain.model.Result
import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.TransactionRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test

class GetTransactionsUseCaseImplTest {

    private val dummyUser = User("1234", "Jack Sparrow")
    private val getUserUseCase: GetUserUseCase = mock { whenever(it()).thenReturn(dummyUser) }
    private val repositoryResult = Result.Failure(Throwable())
    private val transactionRepository: TransactionRepository = mock {
        whenever(it.getTransactions(dummyUser.id)).thenReturn(Single.just(repositoryResult))
    }
    private val sut = GetTransactionsUseCaseImpl(getUserUseCase, transactionRepository)

    @Test
    fun `invoke should return transactionRepository result`() {
        val actual = sut().test()

        actual.assertValue { it === repositoryResult }
    }
}