package com.denisbrandi.functionalusecases.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.denisbrandi.functionalusecases.domain.model.Transaction

interface TransactionListViewModel {

    val state: LiveData<State>

    fun loadTransactions()

    sealed class State {
        object Loading : State()
        data class Content(val transactions: List<Transaction>) : State()
        data class Error(val message: String) : State()
    }

}