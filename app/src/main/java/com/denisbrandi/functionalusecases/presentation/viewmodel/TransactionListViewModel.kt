package com.denisbrandi.functionalusecases.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denisbrandi.functionalusecases.domain.model.Answer
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.domain.usecase.fp.GetTransactionsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TransactionListViewModel(
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    val state = MutableStateFlow<State>(State.Idle)

    fun loadTransactions() {
        state.value = State.Loading
        viewModelScope.launch {
            handleResult(getTransactionsUseCase())
        }
    }

    private fun handleResult(getTransactionsResult: Answer<List<Transaction>, Throwable>) {
        getTransactionsResult.fold(
            success = { transactions -> state.value = State.Content(transactions) },
            failure = { throwable -> state.value = State.Error(throwable.message.orEmpty()) }
        )
    }

    sealed interface State {
        object Idle : State
        object Loading : State
        data class Content(val transactions: List<Transaction>) : State
        data class Error(val message: String) : State
    }

}