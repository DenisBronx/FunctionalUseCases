package com.denisbrandi.functionalusecases.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.usecase.fp.GetTransactionsUseCase
import com.denisbrandi.functionalusecases.presentation.viewmodel.TransactionListViewModel.State
import com.denisbrandi.functionalusecases.utils.MainCoroutineRule
import com.denisbrandi.functionalusecases.utils.TestObserver
import com.denisbrandi.functionalusecases.utils.test
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TransactionListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val getTransactions = object : GetTransactionsUseCase {
        lateinit var result: suspend () -> Answer<List<Transaction>, Throwable>
        override suspend fun invoke() = result()
    }
    private val sut = TransactionListViewModel(getTransactions)

    private lateinit var stateObserver: TestObserver<State>

    @Before
    fun setUp() {
        stateObserver = sut.state.test()
    }

    @Test
    fun `loadTransactions should show loading state while getting transactions`() = runTest {
        getTransactions.result = { awaitCancellation() }

        sut.loadTransactions()

        stateObserver.assertValueHistory(State.Idle, State.Loading)
    }

    @Test
    fun `loadTransactions should show content state when transactions are retrieved`() = runTest {
        val dummyTransactions = listOf(Transaction("dummyId", 50.0, "dummyRecipientId", 0L))
        getTransactions.result = { Answer.Success(dummyTransactions) }

        sut.loadTransactions()

        stateObserver.assertValueHistory(
            State.Idle,
            State.Loading,
            State.Content(dummyTransactions)
        )
    }

    @Test
    fun `loadTransactions should show error state when transactions cannot be retrieved`() =
        runTest {
            val errorMessage = "Something went wrong"
            getTransactions.result = { Answer.Failure(Throwable(errorMessage)) }

            sut.loadTransactions()

            stateObserver.assertValueHistory(State.Idle, State.Loading, State.Error(errorMessage))
        }
}