package com.denisbrandi.functionalusecases.domain.usecase

import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.fakes.FakeTransactionRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetTransactionsUseCaseImplTest {

    private val dummyUser = User("1234", "Jack Sparrow")
    private val repositoryResult = Answer.Failure(Throwable())
    private val transactionRepository = FakeTransactionRepository().apply {
        transactionsResult = repositoryResult
    }
    private val sut = GetTransactionsUseCaseImpl({ dummyUser }, transactionRepository)

    @Test
    fun `getTransactions should return transactionRepository result`() = runTest {
        val actual = sut()

        assertThat(actual).isSameInstanceAs(repositoryResult)
    }
}