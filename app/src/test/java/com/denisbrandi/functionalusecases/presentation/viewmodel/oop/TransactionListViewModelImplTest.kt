package com.denisbrandi.functionalusecases.presentation.viewmodel.oop

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.denisbrandi.functionalusecases.domain.model.Result
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.usecase.oop.GetTransactionsUseCase
import com.denisbrandi.functionalusecases.presentation.viewmodel.TransactionListViewModel.State
import com.jraska.livedata.TestObserver
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class TransactionListViewModelImplTest {

    @get:Rule
    val instantTaskTestRule: TestRule = InstantTaskExecutorRule()

    private val getTransactions: GetTransactionsUseCase = mock()
    private val sut = TransactionListViewModelImpl(getTransactions)

    private lateinit var stateObserver: TestObserver<State>

    @Before
    fun setUp() {
        stateObserver = sut.state.test()
    }

    @Test
    fun `loadTransactions should show loading state while getting transactions`() {
        whenever(getTransactions()).thenReturn(Single.never())

        sut.loadTransactions()

        stateObserver.assertValue(State.Loading)
    }

    @Test
    fun `loadTransactions should show content state when transactions are retrieved`() {
        val dummyTransactions = listOf(Transaction("dummyId", 50.0, "dummyRecipientId", 0L))
        whenever(getTransactions()).thenReturn(Single.just(Result.Success(dummyTransactions)))

        sut.loadTransactions()

        stateObserver.assertValueHistory(State.Loading, State.Content(dummyTransactions))
    }

    @Test
    fun `loadTransactions should show error state when transactions cannot be retrieved`() {
        val errorMessage = "Something went wrong"
        whenever(getTransactions()).thenReturn(Single.just(Result.Failure(Throwable(errorMessage))))

        sut.loadTransactions()

        stateObserver.assertValueHistory(State.Loading, State.Error(errorMessage))
    }
}